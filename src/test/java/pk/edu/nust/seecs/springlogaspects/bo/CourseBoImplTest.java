/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.edu.nust.seecs.springlogaspects.bo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fahad Satti <fahad.satti@gmail.com>
 */
public class CourseBoImplTest {
    
    public CourseBoImplTest() {
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
     * Test of addNewCourse method, of class CourseBoImpl.
     */
    @Test
    public void testAddNewCourse() {
        System.out.println("addNewCourse");
        String courseName = "";
        int creditHours = 0;
        CourseBoImpl instance = new CourseBoImpl();
        Integer expResult = null;
        Integer result = instance.addNewCourse(courseName, creditHours);
        assertEquals(expResult, result);
        
    }
    
}
