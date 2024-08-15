package BookingSystemForBuses;

import BookingSystemForBuses.models.Request;
import BookingSystemForBuses.storage.HashMapStorage;
import BookingSystemForBuses.storage.IStorage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderManagementApp {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        IStorage bookingStorage = new HashMapStorage();

        BookingService bookingService = new BookingService(bookingStorage, paymentService);

        Runnable task1 = () -> {
            Request request1 = new Request(2, "a", "b", "U1");
            bookingService.createBooking(request1);
        };

        Runnable task2 = () -> {
            Request request2 = new Request(3, "a", "c", "U2");
            bookingService.createBooking(request2);
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(task1);
        executorService.submit(task2);
    }
}
