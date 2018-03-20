package testex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import testex.fetchers.FetcherFactory;
import testex.fetchers.IFetcherFactory;
import testex.fetchers.IJokeFetcher;

@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {

    @Mock
    IDateFormatter mockDateFormatter;

    @Mock
    IFetcherFactory mockFactory;
    
    @Mock
    IJokeFetcher MomaFetcher, EduJokeFetcher,ChuckNorrisFetcher,TambalFetcher;
    
    public JokeFetcherTest() {
    }


    @Before
    public void setUp() {
    }


    @Test
    public void testGetAvailableTypes() {

        JokeFetcher fetcher = new JokeFetcher(new FetcherFactory(), new DateFormatter());
        List<String> expResult = Arrays.asList("eduprog", "chucknorris", "moma", "tambal");
        List<String> result = fetcher.getAvailableTypes();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsStringValid() {
        String jokeTokens = "moma";
        JokeFetcher fetcher = new JokeFetcher(new FetcherFactory(), new DateFormatter());
        boolean expResult = true;
        boolean result = fetcher.isStringValid(jokeTokens);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsStringValidNotInTypes() {
        String jokeTokens = "test";
        JokeFetcher fetcher = new JokeFetcher(new FetcherFactory(), new DateFormatter());
        boolean expResult = false;
        boolean result = fetcher.isStringValid(jokeTokens);
        assertEquals(expResult, result);
    }
    
    @Test(expected = JokeException.class)
    public void testGetInvalidJoke() throws JokeException {
        JokeFetcher jf = new JokeFetcher(new FetcherFactory(), new DateFormatter());
        String jokesToFetch = "swag2";
        String timeZone = "Europe/Copenhagen";
        jf.getJokes(jokesToFetch, timeZone);
    }
    
    @Test
    public void testGetOneJoke() throws JokeException {
        String jokeType = "moma";
        List<String> types = new ArrayList<String>();
        types.add(jokeType);
        Joke joke = new Joke("Yo mama so fat, she can't even fit in this test-case","www.fakeApi.com");
        ArrayList<IJokeFetcher> fetchers = new ArrayList<>();
        fetchers.add(MomaFetcher);
        when(mockFactory.getFetchers(jokeType)).thenReturn(fetchers);
        when(MomaFetcher.getJoke()).thenReturn(joke);
        String timeZone = "Europe/Copenhagen";
        when(mockFactory.getAvailableTypes()).thenReturn(types);
        when(mockDateFormatter.getFormattedDate(timeZone, new Date())).thenReturn("");
        String expResult = "Joke{joke=Yo mama so fat, she can't even fit in this test-case, reference=www.fakeApi.com}";
        JokeFetcher jokeFetcher = new JokeFetcher(mockFactory, mockDateFormatter);
        Jokes jokes = jokeFetcher.getJokes(jokeType, timeZone);
        assertEquals(expResult, jokes.getJokes().get(0).toString());
    }
   
    
    @Test
    public void getJokes()throws JokeException{
           String jokeTypes = "eduprog,chucknorris,moma,tambal";
           String timeZone = "Europe/Copenhagen";
           ArrayList<IJokeFetcher> fetchers = new ArrayList<>();
           fetchers.add(MomaFetcher);
           fetchers.add(EduJokeFetcher);
           fetchers.add(ChuckNorrisFetcher);
           fetchers.add(TambalFetcher);
           when(MomaFetcher.getJoke()).thenReturn(new Joke("Amazing Joke 1","www.fakeApi.com"));
           when(EduJokeFetcher.getJoke()).thenReturn(new Joke("Amazing Joke 2","www.fakeApi.com"));
           when(ChuckNorrisFetcher.getJoke()).thenReturn(new Joke("Amazing Joke 3","www.fakeApi.com"));
           when(TambalFetcher.getJoke()).thenReturn(new Joke("Amazing Joke 4","www.fakeApi.com"));
           when(mockFactory.getFetchers(jokeTypes)).thenReturn(fetchers);
           when(mockFactory.getAvailableTypes()).thenReturn(Arrays.asList(jokeTypes.split(",")));
           when(mockDateFormatter.getFormattedDate(timeZone, new Date())).thenReturn("");
           JokeFetcher jokeFetcher = new JokeFetcher(mockFactory, mockDateFormatter);
           Jokes jokes = jokeFetcher.getJokes(jokeTypes, timeZone);
           int tempCount = 1;
           for(Joke j : jokes.getJokes()){
               assertEquals("Joke{joke=Amazing Joke " + tempCount + ", reference=www.fakeApi.com}", j.toString());
               tempCount++;
           }
    }
    

    
//    @Test
//    public void testFetcherFactory() {
//        
//    }

}
