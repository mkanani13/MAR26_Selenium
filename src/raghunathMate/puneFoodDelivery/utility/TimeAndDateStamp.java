package raghunathMate.puneFoodDelivery.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeAndDateStamp {

    private TimeAndDateStamp () {

    }

    public static String getCurrentDateAndTime(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
        return LocalDateTime.now().format(formatter);
    }
}
