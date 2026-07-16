package Amitjoshi.TechnoAppTesting.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

private  final  class DateTimeUtility {

    private DateTimeUtility(){

    }
    public static String getcurrentDateTime(){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("DD MM YYYY, HH:mm a ");
        return LocalDateTime.now().format(formatter);
    }
}