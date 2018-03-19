package testex;

import java.util.Date;

public interface IDateFormatter {
    
    public String getFormattedDate(String timeZone, Date d) throws JokeException;
}
