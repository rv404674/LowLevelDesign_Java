package BookingSystemForBuses.gateways;

public interface IGateway {
    String createOrder(int amount);

    GatewayType getGatewayType();
}
