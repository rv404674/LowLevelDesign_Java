package BookingSystemForBuses;

import BookingSystemForBuses.gateways.GatewayFactory;
import BookingSystemForBuses.gateways.GatewayType;
import BookingSystemForBuses.gateways.IGateway;
import BookingSystemForBuses.models.Request;
import BookingSystemForBuses.storage.HashMapStorage;
import BookingSystemForBuses.storage.IStorage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderManagementApp {
    public static void main(String[] args) {
        // FLOWS
        // FLOW1
        // createBooking() -> createOrder
        // FLOW2 (client initiateid, client does the payment)
        // makePayment() -> update Payments table, update Orders table.
        // FLOW3 (CAPTURED) -> Razorpay webhook will hit markPaymentConfirmed();
        IGateway gateway = GatewayFactory.getGateway(GatewayType.RAZORPAY.toString());
        PaymentService paymentService = new PaymentService(gateway);
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
