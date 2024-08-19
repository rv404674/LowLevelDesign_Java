package BookingSystemForBuses;

import BookingSystemForBuses.models.Booking;
import BookingSystemForBuses.models.BookingStatus;
import BookingSystemForBuses.models.Fare;
import BookingSystemForBuses.models.Order;
import BookingSystemForBuses.models.Request;
import BookingSystemForBuses.models.StateValidation;
import BookingSystemForBuses.storage.IStorage;

import java.util.concurrent.locks.ReentrantLock;

// order creation
// order confirmation
public class BookingService {

    ReentrantLock writeLock;
    IStorage bookingStorage;
    PaymentService paymentService;

    public BookingService(IStorage bookingStorage, PaymentService paymentService) {
        this.bookingStorage = bookingStorage;
        this.paymentService = paymentService;
        this.writeLock = new ReentrantLock();
    }

    public Booking createBooking(Request request) {
        Fare fare = calculateFare(request);

        // handle concurrency.
        writeLock.lock();
        try {
            // created booking
            Booking booking = new Booking(request.getFromStop(), request.getToStop(), fare, 2, request.getUserId());
            System.out.println("Create Booking started by " + request.getUserId());

            // create order.
            Order order = this.paymentService.createOrder(booking);
            booking.setOrder(order);
            System.out.println("Booking written to the db " + booking);
            this.bookingStorage.write(booking.getBookingId(), booking);
            return booking;
        } finally {
            writeLock.unlock();
        }

    }

    // This is being hit by the payment service, after money has been recieved.
    public boolean confirmBooking(Booking booking, BookingStatus status) {
        // validation
        if (!StateValidation.isValidPath(booking.getBookingStatus(), status)) {
            System.out.println("Invalid state transition");
            return false;
        }

        // Will be updated by default in hashamp;
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        return true;
    }

    public Fare calculateFare(Request request) {
        return new Fare(
                100 * request.getSeatCount(),
                5 * request.getSeatCount()
        );
    }

}
