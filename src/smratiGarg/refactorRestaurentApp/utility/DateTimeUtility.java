package smratiGarg.refactorRestaurentApp.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtility {
    public static String getCurrentDateTime(){

        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm a");
        String timestamp = now.format(formatter);
//        System.out.println(timestamp);
        return timestamp;
    }

    public static String getCurrentDateTime(String pattern){

        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String timestamp = now.format(formatter);
//        System.out.println(timestamp);
        return timestamp;
    }


}
