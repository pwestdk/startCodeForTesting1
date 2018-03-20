package testex.fetchers;

import static com.jayway.restassured.RestAssured.given;
import testex.Joke;

public class ChuckNorriesFetcher implements IJokeFetcher {

    @Override
    public Joke getJoke() {
        try {
            String joke = given().get("http://api.icndb.com/jokes/random").path("value.joke");
            return new Joke(joke, "http://api.icndb.com/");
        } catch (Exception e) {
            return null;
        }
    }

}
