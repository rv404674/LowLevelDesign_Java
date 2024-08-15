package BookingSystemForBuses;

import BookingSystemForBuses.models.Order;
import BookingSystemForBuses.models.Payment;

public class PaymentService {

    public void makePayment(Order order, int amount) {
        System.out.println("Making Payment - hitting Razropay");
        int paymentId = order.getPayments().size() + 1;
        Payment payment = new Payment(paymentId, amount);
        order.addPayment(payment);
        System.out.println("Hitting Razorpy with payment " + payment);
    }

    public void markPaymentConfirmed() {
        // SOUT("mark it confirmed)
    }
}
