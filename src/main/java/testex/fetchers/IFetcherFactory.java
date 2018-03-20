package testex.fetchers;

import java.util.ArrayList;
import java.util.List;

public interface IFetcherFactory {
    
    
    public ArrayList<IJokeFetcher> getFetchers(String jokeTypes);
    
    public List<String> getAvailableTypes();
}
