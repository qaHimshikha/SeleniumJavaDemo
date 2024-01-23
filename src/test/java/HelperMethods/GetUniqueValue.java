package HelperMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetUniqueValue {
    public String getUniqueValue() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}