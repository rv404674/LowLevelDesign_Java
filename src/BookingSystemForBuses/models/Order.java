package BookingSystemForBuses.models;

import java.util.ArrayList;
import java.util.List;

// (orderId (given by razorpay), bookingId, chalOrderId (chalo's identifier), amount ...)
public class Order {
    String orderId;
    List<Payment> payments;
    String gatewayType;

    public Order(String orderId, String gatewayType) {
        this.orderId = orderId;
        this.gatewayType = gatewayType;
        this.payments = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", payments=" + payments +
                ", gatewayType='" + gatewayType + '\'' +
                '}';
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }
}
