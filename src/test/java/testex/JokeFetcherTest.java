/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        System.out.println("getAvailableTypes");
        JokeFetcher instance = new JokeFetcher();
        List<String> expResult = null;
        List<String> result = instance.getAvailableTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStringValid method, of class JokeFetcher.
     */
    @Test
    public void testIsStringValid() {
        System.out.println("isStringValid");
        String jokeTokens = "";
        JokeFetcher instance = new JokeFetcher();
        boolean expResult = false;
        boolean result = instance.isStringValid(jokeTokens);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJokes method, of class JokeFetcher.
     */
    @Test
    public void testGetJokes() throws Exception {
        System.out.println("getJokes");
        String jokesToFetch = "";
        String timeZone = "";
        JokeFetcher instance = new JokeFetcher();
        Jokes expResult = null;
        Jokes result = instance.getJokes(jokesToFetch, timeZone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class JokeFetcher.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        JokeFetcher.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
