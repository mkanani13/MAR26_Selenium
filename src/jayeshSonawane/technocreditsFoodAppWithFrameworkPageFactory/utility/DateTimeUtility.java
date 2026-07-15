package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtility {

    private DateTimeUtility(){

    }

    public static String getCurrentDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm a");
        return LocalDateTime.now().format(formatter); // 2026-06-28T09:55:08.778501400
    }
}
