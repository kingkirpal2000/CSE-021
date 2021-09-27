import java.util.Scanner;

public class remainderfunc {

	public static void main(String[] args) {
		int divisor;
		boolean containsNums = false;
		System.out.print("Please enter the max number: ");
		Scanner input = new Scanner(System.in);
		int maxNum = input.nextInt();
		if (maxNum < 0) {
			while (maxNum < 0) {
				System.out.print("Invalid input. Please enter a max number > 0: ");
				maxNum = input.nextInt();
			} }
		if (maxNum > 0) {
			System.out.print("Please enter the divisor.");
		}
		
		divisor = input.nextInt();
		
		if (divisor <= 0) {
			while (divisor <= 0) {
			System.out.print("Invalid input. Please enter a divisor > 0: ");
			divisor = input.nextInt();
			}
		}
		
		
		
		
		if (divisor > 0) {
			System.out.println("Multiples of " + divisor + " between 1 and " + maxNum + " are:");
			
			for(int i = 1; i < maxNum; i++) {
				if (i % divisor == 0) {
					System.out.println(i);
					containsNums = true;
					
				}	
			}	
		}
		
		if (containsNums == false) {
			System.out.println("No numbers were found.");
		}
			
		

	}

}
