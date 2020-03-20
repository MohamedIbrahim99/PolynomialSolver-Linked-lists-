package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class polynomialImplementationTest {

	@Test
	public void test() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "(5,2),(5,2),(3,3),(4,7)";
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial
        
  		int[][] terms2 = new int[100][2];
        s = "( 7 , 3) , ( 8,6 ),(9,1)";
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial
		
        int[][] result = polynomial.add('A','B');
        int [][] arr1 =
			{
					{4, 7},
					{8, 6},
					{10, 3},
					{10, 2},
					{9, 1},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test1() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "(4,2),(4,3),(4,2),(4,2),(4,3),(4,3),(4,3),(4,3)";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial
        
  		int[][] terms2 = new int[100][2];
        s = "(4,2),(3,3),(4,2),(4,2),(4,2),(4,2),(4,2)";		
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial
		
								//test add function
								//very important test
        int[][] result = polynomial.add('A','B');
        int [][] arr1 =
			{
					{23, 3},
					{36, 2},
					};
        assertArrayEquals(arr1,result);
	}
	
	 
	@Test
	public void test2() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "(4,2),(4,3),(4,2),(4,2),(4,3),(4,3),(4,3),(4,3)";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial
        
  		int[][] terms2 = new int[100][2];
        s = "(4,2),(3,3),(4,2),(4,2),(4,2),(4,2),(4,2)";		
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial

        // add test
        int[][] result = polynomial.add('A','B');
        int [][] arr1 =
			{
					{23, 3},
					{36, 2},
					};
        assertArrayEquals(arr1,result);
	}
	@Test
	public void test3() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "{5,6}, {-10,8}, {3,5}";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial test
        
  		int[][] terms2 = new int[100][2];
        s = "{6,4}";		
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial 
		
        // Multiply test
        int[][] result = polynomial.multiply('A','B');
        int [][] arr1 =
			{
					{-60, 12},
					{30, 10},
					{18, 9},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test4() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "{5,6}, {-10,8}, {3,5}";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial test
        
  		int[][] terms2 = new int[100][2];
        s = "{0,4}";		
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial 

        // Zero multiplication test
        int[][] result = polynomial.multiply('A','B');
        int [][] arr1 =
			{
					{0, 12},
					{0, 10},
					{0, 9},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test5() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "(9,7),(8,8),(5,4),(4,2)";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial 
        
        // Evaluate Test
        float result =  polynomial.evaluatePolynomial('A',3);
        float expected =  72612f ;
        assertEquals(expected, result, 0);
	}
	
	@Test
	public void test7() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "{10,3},{9,4},{6,4},{3,5},{2,2}";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial test
             
        // Evaluate test
        float result =  polynomial.evaluatePolynomial('A',5);
        float expected =  20050f ;
        assertEquals(expected, result, 0);
        
	}
	
	@Test
	public void test8() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "(1,6),(1,7),(1,8)";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial test
        
  		int[][] terms2 = new int[100][2];
        s = "(1,9),(1,6),(1,7)";		
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial 
		
        // Subtraction Test
        int[][] result = polynomial.subtract('A','B');
        int [][] arr1 =
			{
				{-1,9},{1,8},{0, 7},{0, 6},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test9() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "{0,0},{0, 0},{0,0}";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial test
        
  		int[][] terms2 = new int[100][2];
        s = "{0,0},{0, 0},{0,0}";		
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial 
		
        //Zero subtraction test
        int[][] result = polynomial.subtract('A','B');
        int [][] arr1 =
			{
				{0,0},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test10() {
		polynomialImplementation polynomial = new polynomialImplementation();
		
		int[][] terms1 = new int[100][2];
		String s = "(7,4),(5,5),(3,1)";	
		
		int rowsNum = User_Interface.enterMatrixFromString(s, terms1, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);			// To Edit the number of the nodes
        
        polynomial.setPolynomial('A',terms1);		// Set Polynomial test
        
  		int[][] terms2 = new int[100][2];
        s = "(5,3),(6,6),(2,4)";		
        rowsNum = User_Interface.enterMatrixFromString(s, terms2, 100, 2);		// Convert from string to 2d array
        polynomial.editRowsNumber(rowsNum);				// To Edit the number of the nodes
        
        polynomial.setPolynomial('B',terms2);			// Set Polynomial 
        
        // Subtraction test
        int[][] result = polynomial.subtract('A','B');
        int [][] arr1 =
			{
				{-6,6},{5,5},{5,4},{-5,3},{3,1},
					};
        assertArrayEquals(arr1,result);
	}
	
	
	
	 

}
