/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.Date;
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
public class DateFormatterTest {
    
    public DateFormatterTest() {
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
     * Test of getFormattedDate method, of class DateFormatter.
     */
    @Test
    public void testGetFormattedDate() throws Exception {
        System.out.println("getFormattedDate");
        String timeZone = "";
        String expResult = "";
        String result = DateFormatter.getFormattedDate(timeZone, new Date());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test(expected = JokeException.class)
    public void badFormattedString() throws JokeException{
        String timeZone = "swag";
        DateFormatter.getFormattedDate(timeZone, new Date());
    }

    
}
