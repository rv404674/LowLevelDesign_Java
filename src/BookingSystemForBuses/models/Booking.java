package BookingSystemForBuses.models;

import java.util.UUID;

public class Booking {
    String bookingId;
    String fromStop;
    String toStop;
    Fare fare;
    int seatCount;
    long createdAt;
    long expiredAt;
    BookingStatus bookingStatus;
    Order order;
    String userId;
    String reservationId;

    public Booking(String fromStop, String toStop, Fare fare, int seatCount, String userId) {
        this.bookingId = UUID.randomUUID().toString();
        this.fromStop = fromStop;
        this.toStop = toStop;
        this.fare = fare;
        this.seatCount = seatCount;
        this.userId = userId;
        this.bookingStatus = BookingStatus.IN_PROGRESS;
        this.createdAt = System.currentTimeMillis();
        // TTL of 5mins.
        this.expiredAt = this.createdAt + 5 * 60 * 1000;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", fromStop='" + fromStop + '\'' +
                ", toStop='" + toStop + '\'' +
                ", fare=" + fare +
                ", seatCount=" + seatCount +
                ", createdAt=" + createdAt +
                ", expiredAt=" + expiredAt +
                ", bookingStatus=" + bookingStatus +
                ", order=" + order +
                ", userId='" + userId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
