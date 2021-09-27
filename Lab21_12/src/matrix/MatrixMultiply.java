package matrix;
import java.util.*;
import java.io.*;

public class MatrixMultiply {
	
	public static void main(String[] args) {
	
		int[][] matrix1 = readMatrix("data/matrix1.txt");
		int[][] matrix2 = readMatrix("data/matrix1.txt");
		int[][] matrix3 = readMatrix("data/matrix1.txt");
		int[][] matrix4 = readMatrix("data/matrix1.txt");
		
		writeMatrix((multiply(matrix1, matrix2)), "Result1.txt");
		writeMatrix((multiply(matrix2, matrix3)), "Result2.txt");
		writeMatrix((multiply(matrix2, matrix4)), "Result3.txt");
	}

	
	public static int[][] readMatrix() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the file name: ");
		String filename = input.next();
		
		return readMatrix(filename);
		
	}
	
	
	
	
	

	public static int[][] readMatrix(String filename) {
		int[][] myMatrix = null; 
		try {
			Scanner rL = new Scanner(new FileReader(filename));
			int row = rL.nextInt();
			int column = rL.nextInt();
			myMatrix = new int[row][column];
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < column; j++) {
					myMatrix[i][j] = rL.nextInt();
				}
			}
			
			
			
			

		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return myMatrix; 
	} 


	
	
	// writes a matrix to the file
	public static void writeMatrix(int[][] matrix, String filename) {

	
		   try {
		      FileWriter output = new FileWriter(filename);
		      String ostr = "";
		      for (int i = 0; i < matrix.length; i++) {
		         for (int j = 0; j < matrix[0].length; j++) {
		            System.out.print(ostr = (matrix[i][j] + "\t"));
		            output.write(ostr);
		         }
		         System.out.println();
		         output.write("\r\n"); // Carriage return
		}
		      output.close();
		   } catch(Exception e) {
		      System.out.println(e);
		   }
		
	}
	
	
	
	
	// returns the multiplied matrix
	public static int[][] multiply(int[][] m1, int[][] m2) {

		int m1rows = m1.length;
		int m1cols = m1[0].length;
		int m2rows = m2.length;
		int m2cols = m2[0].length;
		int[][] result = new int[m1rows][m2cols];
		for (int i = 0; i < m1rows; i++) {
			for (int j = 0; j < m2cols; j++) {
				for (int k = 0; k < m1cols; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}


	
	
	// prints a matrix
	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				// 'format' will print 5 spaces no matter what, which will 
				// help line things up.
				System.out.format("%5d ", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	

	

}
