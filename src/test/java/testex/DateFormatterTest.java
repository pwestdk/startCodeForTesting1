package testex;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateFormatterTest {
    
    @Mock
    IDateFormatter mockDateFormatter;

    @Test
    public void testGetFormattedDate() throws Exception {
        DateFormatter dateformatter = new DateFormatter(mockDateFormatter);
        String timeZone = "Europe/Copenhagen";
        Date d = new Date(1);
        when(mockDateFormatter.getFormattedDate(timeZone, d)).thenReturn("01 Jan 1970 01:00 AM");
        String expResult = "01 Jan 1970 01:00 AM";
        String result = dateformatter.getFormattedDate(timeZone, d);
        assertEquals(expResult, result);
    }
    
    @Test(expected = JokeException.class)
    public void badFormattedString() throws JokeException{
        DateFormatter dateformatter = new DateFormatter(mockDateFormatter);
        String timeZone = "swag";
        dateformatter.getFormattedDate(timeZone, new Date());
    }
}
