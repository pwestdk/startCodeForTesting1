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
import org.mockito.Mock;

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

    @Test
    public void testGetFormattedDate() throws Exception {
        String timeZone = "Europe/Copenhagen";
        String expResult = "01 Jan 1970 01:00 AM";
        String result = DateFormatter.getFormattedDate(timeZone, new Date(1));
        assertEquals(expResult, result);
    }
    
    @Test(expected = JokeException.class)
    public void badFormattedString() throws JokeException{
        String timeZone = "swag";
        DateFormatter.getFormattedDate(timeZone, new Date());
    }

    
}
