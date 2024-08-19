package BookingSystemForBuses.models;

import java.util.HashMap;
import java.util.List;

public class StateValidation {
    static HashMap<BookingStatus, List<BookingStatus>> validationStates = new HashMap<>();

    static {
        validationStates.put(BookingStatus.INITIATED,
                List.of(BookingStatus.INITIATED, BookingStatus.CONFIRMED, BookingStatus.EXPIRED, BookingStatus.CANCELLED, BookingStatus.FAILED));
        validationStates.put(BookingStatus.CONFIRMED,
                List.of(BookingStatus.CONFIRMED, BookingStatus.FAILED, BookingStatus.CANCELLED));
        validationStates.put(BookingStatus.FAILED, List.of(BookingStatus.FAILED));
        validationStates.put(BookingStatus.CANCELLED, List.of(BookingStatus.CANCELLED));
        validationStates.put(BookingStatus.EXPIRED, List.of(BookingStatus.EXPIRED));
    }


    public static boolean isValidPath(BookingStatus fromStatus, BookingStatus toStatus) {
        List<BookingStatus> allowedStatus = validationStates.get(fromStatus);
        return allowedStatus.contains(toStatus);
    }
}
