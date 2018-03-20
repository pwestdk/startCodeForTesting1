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

public class JokeFetcher {

    private IFetcherFactory factory;
    private IDateFormatter formatter;

    public JokeFetcher(IFetcherFactory factory, IDateFormatter formatter) {
        this.factory = factory;
        this.formatter = formatter;
    }

    public List<String> getAvailableTypes() {
        return factory.getAvailableTypes();
    }

    boolean isStringValid(String jokeTokens) {
        String[] tokens = jokeTokens.split(",");
        for (String token : tokens) {
            if (!factory.getAvailableTypes().contains(token)) {
                return false;
            }
        }
        return true;
    }

    public Jokes getJokes(String jokesToFetch, String timeZone) throws JokeException {
        if (!isStringValid(jokesToFetch)) {
            throw new JokeException("Inputs (jokesToFetch) contain types not recognized");
        }
        Jokes jokes = new Jokes();
        ArrayList<IJokeFetcher> fetched = factory.getFetchers(jokesToFetch);
        for (IJokeFetcher fetcher : fetched) {
            jokes.addJoke(fetcher.getJoke());
        }
        String timeZoneString = formatter.getFormattedDate(timeZone, new Date());
        jokes.setTimeZoneString(timeZoneString);
        return jokes;
    }

    public static void main(String[] args) throws JokeException {
//        JokeFetcher jf = new JokeFetcher(new FetcherFactory(), new DateFormatter());
//        Jokes jokes = jf.getJokes("eduprog,chucknorris,chucknorris,moma,tambal", "Europe/Copenhagen");
//        jokes.getJokes().forEach((joke) -> {
//            System.out.println(joke);
//        });
//        System.out.println("Is String Valid: " + jf.isStringValid("edu_prog,xxx"));
    }
}
