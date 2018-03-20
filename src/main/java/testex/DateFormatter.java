package testex;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter implements IDateFormatter {
    
    private IDateFormatter formatter;

    public DateFormatter(IDateFormatter formatter) {
        this.formatter = formatter;
    }
    
  public String getFormattedDate(String timeZone, Date d) throws JokeException  {
    if(!Arrays.asList(TimeZone.getAvailableIDs()).contains(timeZone)){
      throw new JokeException("Illegal Time Zone String");
    }
    String dateTimeFormat = "dd MMM yyyy hh:mm aa";
    SimpleDateFormat simpleFormat = new SimpleDateFormat(dateTimeFormat);
    simpleFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
    return simpleFormat.format(d); 
  }

  public static void main(String[] args) throws JokeException  {
    //for (String str : TimeZone.getAvailableIDs()) {
    //  System.out.println(str);
   // }
    //Executing our public method with a valid String:
    //System.out.println(new DateFormatter().getFormattedDate("Europe/Kiev", new Date()));
    //System.out.println(getFormattedDate("Europe/Copenhagen", new Date()));
    //System.out.println(new DateFormatter().getFormattedDate("ImNotLegal", new Date()));
  }
}
