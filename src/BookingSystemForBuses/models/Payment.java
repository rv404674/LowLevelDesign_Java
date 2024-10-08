package BookingSystemForBuses.models;

// (paymentId, orderId, status, ..)
public class Payment {
    int paymentId;
    PaymentStatus paymentStatus;
    int amount;
    long createdAt;

    public Payment(int paymentId, int amount) {
        this.paymentId = paymentId;
        this.paymentStatus = PaymentStatus.INITIATED;
        this.amount = amount;
        this.createdAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentStatus=" + paymentStatus +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
