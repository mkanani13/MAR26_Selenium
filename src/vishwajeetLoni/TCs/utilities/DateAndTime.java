package vishwajeetLoni.TCs.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateAndTime {
//no one can edit the class now
    private DateAndTime(){
// no one can create an object of class
    }

    public static String getCurrentTime(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formated = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");  //
        String formattedTime = current.format(formated);
        return formattedTime;
    }

    public static String getCurrentTime(String pattern){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formated = DateTimeFormatter.ofPattern(pattern);  //
        String formattedTime = current.format(formated);
        return formattedTime;
    }

}
