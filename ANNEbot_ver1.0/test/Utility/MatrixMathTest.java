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
public class MatrixMathTest {
    
    public MatrixMathTest() {
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
     * Test of add method, of class MatrixMath.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        double[][] mat1 = new double[][] {{1}};
        double[][] mat2 = new double[][] {{2}};
        double[][] mat3 = new double[][] {{3}};
        
        Matrix matA = new Matrix(mat1);
        Matrix matB = new Matrix(mat2);
        Matrix expResult = new Matrix(mat3);
        Matrix result = MatrixMath.add(matA, matB);
        assertEquals(expResult.get(0, 0), result.get(0, 0),0.0);
        
    }

    /**
     * Test of subtract method, of class MatrixMath.
     */
    @Test
    public void testSubtract() throws Exception {
        System.out.println("subtract");
        double[][] mat1 = new double[][] {{1}};
        double[][] mat2 = new double[][] {{2}};
        double[][] mat3 = new double[][] {{-1}};
        
        Matrix matA = new Matrix(mat1);
        Matrix matB = new Matrix(mat2);
        Matrix expResult = new Matrix(mat3);
        
        Matrix result = MatrixMath.subtract(matA, matB);
        assertEquals(expResult.get(0, 0), result.get(0, 0),0.0);
    }

    /**
     * Test of scalarMultiply method, of class MatrixMath.
     */
    @Test
    public void testScalarMultiply() {
        System.out.println("scalarMultiply");
        double[][] mat1 = new double[][] {{1}};
        Matrix matA = new Matrix(mat1);
        double scalar = 5.0;
        double[][] mat3 = new double[][] {{5.0}};
        Matrix expResult = new Matrix(mat3);
        Matrix result = MatrixMath.scalarMultiply(matA, scalar);
        assertEquals(expResult.get(0, 0), result.get(0, 0),0.0);
    }

    /**
     * Test of multiply method, of class MatrixMath.
     */
    @Test
    public void testMultiply() throws Exception {
        System.out.println("multiply");
        double[][] mat1 = new double[][] {{1}};
        double[][] mat2 = new double[][] {{2}};
        double[][] mat3 = new double[][] {{2}};
        
        Matrix matA = new Matrix(mat1);
        Matrix matB = new Matrix(mat2);
        Matrix expResult = new Matrix(mat3);
        Matrix result = MatrixMath.multiply(matA, matB);
        assertEquals(expResult.get(0, 0), result.get(0, 0),0.0);
    }

    /**
     * Test of dotProduct method, of class MatrixMath.
     */
    @Test
    public void testDotProduct() throws Exception {
        System.out.println("dotProduct");
        double[][] mat1 = new double[][] {{1}};
        double[][] mat2 = new double[][] {{2}};
        
        Matrix matA = new Matrix(mat1);
        Matrix matB = new Matrix(mat2);
        double expResult = 2.0;
        double result = MatrixMath.dotProduct(matA, matB);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of transpose method, of class MatrixMath.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        double[][] mat1 = new double[][] {{1}};
        Matrix matA = new Matrix(mat1);
        double[][] mat3 = new double[][] {{1}};
        Matrix expResult = new Matrix(mat3);
        Matrix result = MatrixMath.transpose(matA);
        assertEquals(expResult.get(0, 0), result.get(0, 0),0.0);
        
    }

    /**
     * Test of identity method, of class MatrixMath.
     */
    @Test
    public void testIdentity() {
        System.out.println("identity");
        int numOfRows = 1;
        double[][] mat3 = new double[][] {{1}};
        Matrix expResult = new Matrix(mat3);
        Matrix result = MatrixMath.identity(numOfRows);
        assertEquals(expResult.get(0, 0), result.get(0, 0),0.0);
        
    }

}
