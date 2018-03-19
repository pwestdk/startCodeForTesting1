/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import testex.fetchers.FetcherFactory;

/**
 *
 * @author pwc
 */
public class JokeFetcherTest {
    
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

    /**
     * Test of getAvailableTypes method, of class JokeFetcher.
     */
    @Test
    public void testGetAvailableTypes() {

        JokeFetcher fetcher = new JokeFetcher(new FetcherFactory());
        List<String> expResult = Arrays.asList("eduprog","chucknorris","moma","tambal");
        List<String> result = fetcher.getAvailableTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isStringValid method, of class JokeFetcher.
     */
    @Test
    public void testIsStringValid() {
        String jokeTokens = "moma";
        JokeFetcher fetcher = new JokeFetcher(new FetcherFactory());
        boolean expResult = true;
        boolean result = fetcher.isStringValid(jokeTokens);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testIsStringValidNotInTypes() {
        String jokeTokens = "test";
        JokeFetcher fetcher = new JokeFetcher(new FetcherFactory());
        boolean expResult = false;
        boolean result = fetcher.isStringValid(jokeTokens);
        assertEquals(expResult, result);
    }
  
}
