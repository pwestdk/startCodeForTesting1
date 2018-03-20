package testex.fetchers;

import static com.jayway.restassured.RestAssured.given;
import testex.Joke;

public class TambalFetcher implements IJokeFetcher {

    @Override
    public Joke getJoke() {
        try {
            String joke = given().get("http://tambal.azurewebsites.net/joke/random").path("joke");
            return new Joke(joke, "http://tambal.azurewebsites.net/joke/random");
        } catch (Exception e) {
            return null;
        }
    }

}
