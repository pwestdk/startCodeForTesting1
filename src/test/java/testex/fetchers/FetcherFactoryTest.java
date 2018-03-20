/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex.fetchers;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasper
 */
public class FetcherFactoryTest {
    
    public FetcherFactoryTest() {
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
     * Test of getFetchers method, of class FetcherFactory.
     */
    @Test
    public void testGetFetchers() {
        String jokesToFetch = "";
        FetcherFactory instance = new FetcherFactory();
        ArrayList<IJokeFetcher> expResult = null;
        ArrayList<IJokeFetcher> result = instance.getFetchers(jokesToFetch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableTypes method, of class FetcherFactory.
     */
    @Test
    public void testGetAvailableTypes() {
        fail("The test case is a prototype.");
    }
    
}
