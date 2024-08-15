package BookingSystemForBuses.models;

public class Request {
    int seatCount;
    String fromStop;
    String toStop;
    String userId;

    public Request(int seatCount, String fromStop, String toStop, String userId) {
        this.seatCount = seatCount;
        this.fromStop = fromStop;
        this.toStop = toStop;
        this.userId = userId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getFromStop() {
        return fromStop;
    }

    public void setFromStop(String fromStop) {
        this.fromStop = fromStop;
    }

    public String getToStop() {
        return toStop;
    }

    public void setToStop(String toStop) {
        this.toStop = toStop;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
