package testex.fetchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import testex.Jokes;

public class FetcherFactory implements IFetcherFactory {

    private final List<String> availableTypes = Arrays.asList("eduprog","chucknorris","moma","tambal");

    @Override
    public ArrayList<IJokeFetcher> getFetchers(String jokesToFetch) {
        ArrayList<IJokeFetcher> jokes = new ArrayList<>();
        String[] tokens = jokesToFetch.split(",");
        for (String token : tokens) {
            switch (token) {
                case "eduprog":
                    jokes.add(new EducationalProgrammingFetcher());
                    break;
                case "chucknorris":
                    jokes.add(new ChuckNorriesFetcher());
                    break;
                case "moma":
                    jokes.add(new YoMammaFetcher());
                    break;
                case "tambal":
                    jokes.add(new TambalFetcher());
                    break;
            }
        }
        return jokes;
    }

    @Override
    public List<String> getAvailableTypes() {
        return availableTypes;
    }

}
