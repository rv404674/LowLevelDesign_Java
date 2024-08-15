package BookingSystemForBuses.models;

public class Fare {
    int basicFare;
    int surcharge;

    public Fare(int basicFare, int surcharge) {
        this.basicFare = basicFare;
        this.surcharge = surcharge;
    }

    public int getTotalFare() {
        return this.basicFare + this.surcharge;
    }

    public int getBasicFare() {
        return basicFare;
    }

    public void setBasicFare(int basicFare) {
        this.basicFare = basicFare;
    }

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }
}
