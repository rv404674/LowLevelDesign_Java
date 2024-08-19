package BookingSystemForBuses.gateways;

import java.util.UUID;

public class RazorpayGateway implements IGateway {
    String serverUrl;

    public RazorpayGateway() {
        this.serverUrl = "https://razorpay.com";
    }

    @Override
    public String createOrder(int amount) {
        String orderId = UUID.randomUUID().toString();
        return orderId;
    }

    @Override
    public GatewayType getGatewayType() {
        return GatewayType.RAZORPAY;
    }
}
