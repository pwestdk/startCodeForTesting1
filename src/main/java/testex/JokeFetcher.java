
package testex;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.ExtractableResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import testex.fetchers.FetcherFactory;
import testex.fetchers.IFetcherFactory;
import testex.fetchers.IJokeFetcher;

/**
 * Class used to fetch jokes from a number of external joke API's
 */
public class JokeFetcher {
  
    private IFetcherFactory factory;
    
    public JokeFetcher(IFetcherFactory factory){
        this.factory = factory;
    }
  

  public List<String> getAvailableTypes(){
      return factory.getAvailableTypes();
  }
    
  boolean isStringValid(String jokeTokens){
    String[] tokens = jokeTokens.split(",");
      for(String token: tokens){
      if(!factory.getAvailableTypes().contains(token)){
        return false;
      }
    }
    return true;
  }
  
  /**
   * Fetch jokes from external API's as given in the input string - jokesToFetch
   * @param jokesToFetch A comma separated string with values (contained in availableTypes) indicating the jokes
   * to fetch. Example: "eduprog,chucknorris,chucknorris,moma,tambal" will return five jokes (two chucknorris)
   * @param timeZone. Must be a valid timeZone string as returned by: TimeZone.getAvailableIDs()  
   * @return A Jokes instance with the requested jokes + time zone adjusted string representing fetch time
   * (the jokes list can contain null values, if a server did not respond correctly)
   * @throws JokeException. Thrown if either of the two input arguments contains illegal values
   */
  public Jokes getJokes(String jokesToFetch,String timeZone) throws JokeException{
    if(!isStringValid(jokesToFetch)){
      throw new JokeException("Inputs (jokesToFetch) contain types not recognized");
    }
    Jokes jokes = new Jokes();
    ArrayList<IJokeFetcher> fetched = factory.getFetchers(jokesToFetch);
    for(IJokeFetcher fetcher : fetched){
        jokes.addJoke(fetcher.getJoke());
    }
    String timeZoneString = DateFormatter.getFormattedDate(timeZone, new Date());
    jokes.setTimeZoneString(timeZoneString);
    return jokes;
  }
  
  /**
   * DO NOT TEST this function. It's included only to get a quick way of executing the code
   * @param args 
   */
  public static void main(String[] args) throws JokeException {
    JokeFetcher jf = new JokeFetcher( new FetcherFactory());
    Jokes jokes = jf.getJokes("eduprog,chucknorris,chucknorris,moma,tambal","Europe/Copenhagen");
    jokes.getJokes().forEach((joke) -> {
      System.out.println(joke);
    });
    System.out.println("Is String Valid: "+jf.isStringValid("edu_prog,xxx"));
  }
}