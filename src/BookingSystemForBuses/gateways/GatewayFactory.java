package BookingSystemForBuses.gateways;

public class GatewayFactory {
    public static IGateway getGateway(String gatewayType) {
        switch (gatewayType) {
            case "RAZORPAY":
                return new RazorpayGateway();
            default:
                return new RazorpayGateway();
        }
    }
}
