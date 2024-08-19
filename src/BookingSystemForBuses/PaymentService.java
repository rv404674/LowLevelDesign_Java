package BookingSystemForBuses;

import BookingSystemForBuses.gateways.IGateway;
import BookingSystemForBuses.models.Booking;
import BookingSystemForBuses.models.Order;
import BookingSystemForBuses.models.Payment;

public class PaymentService {
    IGateway paymentGateway;

    public PaymentService(IGateway gateway) {
        this.paymentGateway = gateway;
    }

    public Order createOrder(Booking booking) {
        System.out.println("Hitting " + this.paymentGateway.getGatewayType().toString() + "to create order, by user " + booking.getUserId());
        String orderId = paymentGateway.createOrder(booking.getFare().getTotalFare());
        Order order = new Order(orderId, this.paymentGateway.getGatewayType().toString());
        System.out.println("Order created " + order + " for user " + booking.getUserId());
        return order;
    }

    // client initiated.
    // update both orders and payments.
    public void makePayment(Order order, int amount) {
        System.out.println("Making Payment - hitting Razropay");
        int paymentId = order.getPayments().size() + 1;
        Payment payment = new Payment(paymentId, amount);
        order.addPayment(payment);
        System.out.println("Hitting Razorpy with payment " + payment);
    }

    // razorpay webhoook will hit this.
    // update both payment and
    public void markPaymentConfirmed() {
        // SOUT("mark it confirmed)
    }
}
