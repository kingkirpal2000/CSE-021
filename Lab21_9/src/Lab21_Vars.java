import java.util.*;

public class Lab21_Vars {

	public static void main(String[] args) {

		int i = 0, j = 0;
		int var0, var1;
		
		// Fix 1: Correctly typecast 5.0 to an int so it can assigned to var3.
		int var2 = 0, var3 = (int)(5.0); //typecasted 5.0 into an integer 
		
		//int var2 = 0, var3 = 5.0;
		
		// Fix 2: Correctly declare a variable as an array.
		int[] arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; //added [] to int to match the syntax
													   // of declaring an array
		
		//int arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		double[] arrd0 = {0.0, 1.0, 2.0, 3.0, 4.0};
		
		// Fix 3: What's wrong with temp? Fix it.
		if (i < j) {
			int temp = 0;
			System.out.println("Temp is " + temp);
		} else {
			int temp = 0; //variable temp is only declared if the condition of "if" satisfies it
						  // when the compiler jumped over the if statement, it never initialized 
						  // a variable called temp and was yet trying to access it
			//temp = 1;
			System.out.println("Temp is " + temp);
		}
		
		// Fix 4: Correctly calculate square of sums and print it as total.
		int total = 0;
		for(i = 0; i < 10; i++) {
			total += i*i;
		}
		System.out.println("i value is " + i);
		System.out.println("Total is " + total);
		/* variable i is already declared
		 * for loop doesn't keep locally declared variables after it is done using them
		 * for that we declared total outside of the loop*/
		/*for (int i = 0; i < 10; i++) {
			int total = 0;
			total += i*i;
		}*/
		System.out.println("i value is " + i);
		System.out.println("Total is " + total);
		
		// Fix 5: Figure out the logical error in lines 36-42, and correct it.
		Cheese jack;
		Cheese monterey = new Cheese("Monterey");
		jack = monterey;
		System.out.println("Monterey name is " + monterey.getName());
		jack.setName("Jack");
		System.out.println("Jack name is " + jack.getName());
		System.out.println("Monterey name is still " + monterey.getName());
	//Just copied and paste cheese class file from lab 8 to lab 9
		// Fix 6: Make the following code shorter by combining redundant 
		//        (unnecessary/duplicate) statements
		/*Scanner input = new Scanner(System.in);
		System.out.print("Enter first number: ");
		
		if (input.nextInt() > var3) {
			System.out.print("Enter second number: ");
			int num2 = input.nextInt();
			System.out.println("First is greater");
			if (num2 < var3)
				System.out.println("Second is Less than");
			else
				System.out.println("Second is Greater or equal");
		} else {
			System.out.print("Enter second number: ");
			int num2 = input.nextInt();
			System.out.println("First is Less than or equal");
			if (num2 < var3)
				System.out.println("Second is Less than");
			else
				System.out.println("Second is Greater or equal");
		}*/
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num2, firstNumber;
		firstNumber = input.nextInt();
		if (firstNumber > var3) {
			System.out.print("Enter second number: ");
			num2 = input.nextInt();
			System.out.println("First is greater");
		} else {
			System.out.print("Enter second number: ");
			num2 = input.nextInt();
			System.out.println("First is Less than or equal");
		}
		if (num2 < var3)
			System.out.println("Second is Less than");
		else
			System.out.println("Second is Greater or equal");
		// Fix 7: Print out the first number entered by the user
		//        (Hint - You will need to modify the above code)
		System.out.println("First number entered by the user was " + firstNumber);
	}

}
