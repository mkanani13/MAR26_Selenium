package riteshMali.utility;

import nishantBentur.base.BrowserActions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtility extends BrowserActions {

    public static String getCurrentDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy , HH:mm a"); //01 Jul 2026, 04:01 pm

    return LocalDateTime.now().format(formatter);
    }
}
