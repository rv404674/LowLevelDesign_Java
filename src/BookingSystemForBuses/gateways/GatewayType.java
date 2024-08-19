package BookingSystemForBuses.gateways;

public enum GatewayType {
    RAZORPAY,
    PAYU;

    @Override
    public String toString() {
        return this.name();
    }
}
