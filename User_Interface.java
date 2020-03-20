package eg.edu.alexu.csd.datastructure.linkedList.cs;

import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.linkedList.cs.polynomialImplementation;
import eg.edu.alexu.csd.datastructure.linkedList.cs.singlyLinkedList;

public class User_Interface {
	
	// method to convert the sting in the form:(coeff1, exponent1), (coeff2, exponent2),.. to 2d array
	public static int enterMatrixFromString(String s, int[][] matrix, int matrixRow, int matrixCol){
		
		int k ,j = 0 ,i = 0 ,l = 0 ;
		while ( j < s.length() ) {
			if ( Character.isDigit(s.charAt(j)) ){
				k = j ;
				if ( s.charAt(j-1) == '-' ) { j = j-1; }
				while ( k < s.length() && Character.isDigit(s.charAt(k)) ) {
					k++;
				}
				String sub = s.substring(j, k);
				matrix[l][i] =Integer.parseInt(sub);
				j=k+1;
				i++;
				if (i == matrixCol) {
					i = 0;
					l ++;
				}
			}
			else { j++; }
		}
		// l = number of rows
		return l;  // To return number of Rows
	}
	
	// To check if the linked list is set or not
	public static boolean isSet(char variable1 , singlyLinkedList A , singlyLinkedList B , singlyLinkedList C)
	{
			if ( variable1 == 'A' || variable1 == 'B' || variable1 == 'C') {
				if ( variable1 == 'A' && A.isEmpty() ) {
					System.out.println("Variable A Not Set");
					return false;
				}
				if ( variable1 == 'B' && B.isEmpty() ) {
					System.out.println("Variable B Not Set");
					return false;
				}
				if ( variable1 == 'C' && C.isEmpty() ) {
					System.out.println("Variable C Not Set");
					return false;
				}
				else
					return true;
			}
			else if ( variable1 == 'R' ) { return false ; }
			else {
				System.out.println("Not Allowed");
				return false;
			}
	}
	

	public static void main(String[] args) {
		
		char variable = ' ' , variable1 = ' ', variable2 = ' ' ;
		int[][] terms = new int[100][2];
		int[][] termsB = new int[100][2];
		int[][] termsC = new int[100][2];

		Scanner scan = new Scanner(System.in);
		polynomialImplementation poly = new polynomialImplementation();
		
	while(true) {
		// startmenu:
		System.out.println("Please choose an action :");
		System.out.println("-----------------------");
		System.out.println("1- Set a Polynomial variable");
		System.out.println("2- Print the value of a Polynomial variable");
		System.out.println("3- Add two Polynomials");
		System.out.println("4- Subtract two Polynomials");
		System.out.println("5- Multiplay two Polynomials");
		System.out.println("6- Evaluate a Polynomials");
		System.out.println("7- Clear a Polynomial variable");
		System.out.println("======================================================");
		
		//scan:
		int choice = 0;		
		try {
			choice = scan.nextInt();
			}
			catch(RuntimeException e) {
			      System.out.println("Invalid Input");
			}
	
		switch (choice) {
			case 1 : 				// 1- Set a Polynomial variable
				
				while(true) {
					System.out.println("Insert the variable name: A, B or C");
					variable = scan.next().charAt(0);
					if(variable == 'A' || variable == 'B' || variable == 'C') {
						break;
					}
					else 
						System.out.println("Not Allowed");
				}
				
				System.out.println("Insert the Polynomial terms in the form : (coeff1, exponent1), (coeff2, exponent2), ..");
					//scan
				scan.nextLine(); //this is to clear the keyboard buffer
				String str = scan.nextLine() ;
				//
				int w = 0 ;
				if ( variable == 'A') {
					// To convert the sting  in the form:(coeff1, exponent1), (coeff2, exponent2) to 2d matrix
					w = enterMatrixFromString(str, terms, 100,2); 
					poly.editRowsNumber(w);	// TO Edit the number of nodes
					poly.setPolynomial(variable, terms);	// To set the polinomial (the linked list)
				}
				if ( variable == 'B') {
					// To convert the sting  in the form:(coeff1, exponent1), (coeff2, exponent2) to 2d matrix
					w = enterMatrixFromString(str, termsB, 100,2);
					poly.editRowsNumber(w);		// TO Edit the number of nodes
					poly.setPolynomial(variable, termsB);	// To set the polinomial (the linked list)
				}
				if ( variable == 'C') {
					// To convert the sting  in the form:(coeff1, exponent1), (coeff2, exponent2) to 2d matrix
					w = enterMatrixFromString(str, termsC, 100,2);
					poly.editRowsNumber(w); 	// TO Edit the number of nodes
					poly.setPolynomial(variable, termsC);  // To set the polinomial (the linked list)
				}
				
				// To handle the wrong inputs
				if ( w == 0 || !isSet(variable, poly.A , poly.B , poly.C ) ) {
					System.out.println("Polynomial can't be set because of the wrong input");
					System.out.println(".....PLease Try Again.....");
				}
				else
					System.out.printf("Polynomial %c is set\n",variable);
				
				System.out.println("======================================================");
				break;
				
			case 2 : 			// 2- Print the value of a Polynomial variable
				
				// Scan
				// and avoid the invalid inputs and in case ( variable not set)
				boolean flag = false;
				while (!flag){
					System.out.println("Insert the variable name : A,B,C or R");
					//scan
					variable = scan.next().charAt(0) ;
					flag = isSet(variable,poly.A , poly.B , poly.C );
					if ( variable == 'R' && !poly.R.isEmpty() ) { flag = true; }
				}

				System.out.print(variable+" Value : ");
				poly.print(variable);
				System.out.println(" ");
				System.out.println("======================================================");
				break;
				
			case 3 :					// 3- Add two Polynomials
				// Scan
				// and avoid the invalid inputs and in case ( variable not set)
				flag = false;
				while (!flag){
					System.out.println("Insert first operand variable name: A, B or C");
					//scan
					variable1 = scan.next().charAt(0) ;
					flag = isSet(variable1,poly.A , poly.B , poly.C );
				}

				flag = false;
				while (!flag){
					System.out.println("Insert second operand variable name: A, B or C");
					//scan
					variable2 = scan.next().charAt(0) ;
					flag = isSet(variable2,poly.A , poly.B , poly.C );
				}
				
				// R = add them
				int[][] add = poly.add(variable1, variable2);
				System.out.print("Result set in R: ");
				
				int x = ( poly.numOfNodes('R') );
				for(int i = 0; i < x; i++) {
					System.out.print("( ");
					for(int j = 0 ; j < 2 ; j++) {
							System.out.print(add[i][j]);
							if( j == 1) {
								System.out.print(" )");
							}else {
								System.out.print(" , ");
							}
					}
					if(i < x-1) {
						System.out.print(",");
					}
				}
				System.out.println();	
				
				System.out.println("======================================================");
				break;
				
			case 4 : 					// 4- Subtract two Polynomials
				// Scan
				// and avoid the invalid inputs and in case ( variable not set)	
				flag = false;
				while (!flag){
					System.out.println("Insert first operand variable name: A, B or C");
					//scan
					variable1 = scan.next().charAt(0) ;
					flag = isSet(variable1,poly.A , poly.B , poly.C );
				}

				flag = false;
				while (!flag){
					System.out.println("Insert second operand variable name: A, B or C");
					//scan
					variable2 = scan.next().charAt(0) ;
					flag = isSet(variable2,poly.A , poly.B , poly.C );
				}
				
				// R = subtract them
				int[][] subtract = poly.subtract(variable1, variable2);
				System.out.print("Result set in R: ");
				
				x = ( poly.numOfNodes('R') );
				for(int i = 0; i < x; i++) {
					System.out.print("( ");
					for(int j = 0 ; j < 2 ; j++) {
							System.out.print(subtract[i][j]);
							if( j == 1) {
								System.out.print(" )");
							}else {
								System.out.print(" , ");
							}
					}
					if(i < x-1) {
						System.out.print(",");
					}
				}
				System.out.println(" ");
				System.out.println("======================================================");
				break;
				
			case 5 : 					// 5- Multiplay two Polynomials
				// Scan
				// and avoid the invalid inputs and in case ( variable not set)
				flag = false;
				while (!flag){
					System.out.println("Insert first operand variable name: A, B or C");
					//scan
					variable1 = scan.next().charAt(0) ;
					flag = isSet(variable1,poly.A , poly.B , poly.C );
				}

				flag = false;
				while (!flag){
					System.out.println("Insert second operand variable name: A, B or C");
					//scan
					variable2 = scan.next().charAt(0) ;
					flag = isSet(variable2,poly.A , poly.B , poly.C );
				}
				
				// R = multiply them
				int[][] multiply = poly.multiply(variable1, variable2);
				System.out.print("Result set in R: ");
				
				x = ( poly.numOfNodes('R') );
				for(int i = 0; i < x; i++) {
					System.out.print("( ");
					for(int j = 0 ; j < 2 ; j++) {
							System.out.print(multiply[i][j]);
							if( j == 1) {
								System.out.print(" )");
							}else {
								System.out.print(",");
							}
					}
					if(i < x-1) {
						System.out.print(",");
					}
				}
				System.out.println();	
				System.out.println("======================================================");
				break;
				
			case 6 :					// 6- Evaluate a Polynomials
				// Scan
				// and avoid the invalid inputs and in case ( variable not set)
				flag = false;
				while (!flag){
					System.out.println("Insert first operand variable name: A, B, C or R");
					//scan
					variable1 = scan.next().charAt(0) ;
					flag = isSet(variable1,poly.A , poly.B , poly.C );
					if ( variable == 'R' && !poly.R.isEmpty() ) { flag = true; }
				}

				System.out.println("Insert the value : ");
				//scan
				float value = scan.nextFloat();
				//Evaluate
				float result = poly.evaluatePolynomial(variable1, value);
				System.out.println("The Result is : "+result);
				
				System.out.println("======================================================");
				break;
				
			case 7 : 				// 7- Clear a Polynomial variable
				System.out.println("Insert the variable name : A,B,C or R");
				//scan
				variable = scan.next().charAt(0) ;
				if ( variable != 'A' && variable != 'B' && variable != 'C' && variable !='R') {
				System.out.println("Invalid Input");
				System.out.println(".....Try Again.....");
				}
				else
					//clear it
					poly.clearPolynomial(variable);
				
				System.out.println("======================================================");
				break;
				
			default :
				throw new RuntimeException("Invalid Input");			//	
		}
		
		
		
	}
	}
}
