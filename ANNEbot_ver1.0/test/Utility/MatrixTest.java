/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sulantha
 */
public class MatrixTest {
    
    public MatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createRowMatrix method, of class Matrix.
     */
    @Test
    public void testCreateRowMatrix() {
        System.out.println("createRowMatrix");
        double[] myRowMatrix = null;
        Matrix expResult = null;
        Matrix result = Matrix.createRowMatrix(myRowMatrix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createColumnMatrix method, of class Matrix.
     */
    @Test
    public void testCreateColumnMatrix() {
        System.out.println("createColumnMatrix");
        double[] myColMatrix = null;
        Matrix expResult = null;
        Matrix result = Matrix.createColumnMatrix(myColMatrix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Matrix.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int rowNum = 0;
        int colNum = 0;
        Matrix instance = null;
        double expResult = 0.0;
        double result = instance.get(rowNum, colNum);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Matrix.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int rowNum = 0;
        int colNum = 0;
        double value = 0.0;
        Matrix instance = null;
        instance.set(rowNum, colNum, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfRows method, of class Matrix.
     */
    @Test
    public void testGetNumOfRows() {
        System.out.println("getNumOfRows");
        Matrix instance = null;
        int expResult = 0;
        int result = instance.getNumOfRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfCols method, of class Matrix.
     */
    @Test
    public void testGetNumOfCols() {
        System.out.println("getNumOfCols");
        Matrix instance = null;
        int expResult = 0;
        int result = instance.getNumOfCols();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Matrix.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        double value2add = 0.0;
        Matrix instance = null;
        instance.add(value2add);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Matrix.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Matrix instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cloneMatrix method, of class Matrix.
     */
    @Test
    public void testCloneMatrix() {
        System.out.println("cloneMatrix");
        Matrix instance = null;
        Matrix expResult = null;
        Matrix result = instance.cloneMatrix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equal method, of class Matrix.
     */
    @Test
    public void testEqual() {
        System.out.println("equal");
        Matrix matrix2Compare = null;
        double tolerance = 0.0;
        Matrix instance = null;
        boolean expResult = false;
        boolean result = instance.equal(matrix2Compare, tolerance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRow method, of class Matrix.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        int rowNum = 0;
        Matrix instance = null;
        Matrix expResult = null;
        Matrix result = instance.getRow(rowNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCol method, of class Matrix.
     */
    @Test
    public void testGetCol() {
        System.out.println("getCol");
        int colNum = 0;
        Matrix instance = null;
        Matrix expResult = null;
        Matrix result = instance.getCol(colNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVector method, of class Matrix.
     */
    @Test
    public void testIsVector() {
        System.out.println("isVector");
        Matrix instance = null;
        boolean expResult = false;
        boolean result = instance.isVector();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isZero method, of class Matrix.
     */
    @Test
    public void testIsZero() {
        System.out.println("isZero");
        Matrix instance = null;
        boolean expResult = false;
        boolean result = instance.isZero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sum method, of class Matrix.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Matrix instance = null;
        double expResult = 0.0;
        double result = instance.sum();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toPackedArray method, of class Matrix.
     */
    @Test
    public void testToPackedArray() {
        System.out.println("toPackedArray");
        Matrix instance = null;
        double[] expResult = null;
        double[] result = instance.toPackedArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
