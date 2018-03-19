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
    
    public JokeFetcherTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
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
    public void testGetJokes() throws JokeException {
        String jokeType = "moma";
        List<String> types = new ArrayList<String>();
        types.add(jokeType);
        Joke joke = new Joke("Yo mama so fat, she can't even fit in this test-case","www.fakeApi.com");
        IJokeFetcher momaFetcher = Mockito.mock(IJokeFetcher.class);
        ArrayList<IJokeFetcher> fetchers = new ArrayList<>();
        fetchers.add(momaFetcher);
        when(mockFactory.getFetchers(jokeType)).thenReturn(fetchers);
        when(momaFetcher.getJoke()).thenReturn(joke);
        String timeZone = "Europe/Copenhagen";
        when(mockFactory.getAvailableTypes()).thenReturn(types);
        when(mockDateFormatter.getFormattedDate(timeZone, new Date())).thenReturn("");
        String expResult = "Joke{joke=Yo mama so fat, she can't even fit in this test-case, reference=www.fakeApi.com}";
        JokeFetcher jf = new JokeFetcher(mockFactory, mockDateFormatter);
        Jokes jokes = jf.getJokes(jokeType, timeZone);
        assertEquals(expResult, jokes.getJokes().get(0));
    }
    
//    @Test
//    public void testFetcherFactory() {
//        
//    }

}
