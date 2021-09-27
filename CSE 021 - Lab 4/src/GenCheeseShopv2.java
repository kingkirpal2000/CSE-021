import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		System.out.println("\nWe sell " + names.length + " kinds of Cheese (in 0.5 lb packages):");
		
		
		if(names.length > 0) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			amounts[0] = 0.00;
		}if(names.length > 1) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
			amounts[1] = 0.00;
		}
		if(names.length > 2) {
			names[2] = "Teleme";
			prices[2] = 17.25;
			amounts[2] = 0.00;
		}
		
		
		for(int i = 0; i <= names.length; i++) {
			if(names.length > 0) {
				System.out.print(names[0] + ": $");
				System.out.printf("%.2f", prices[0]);
				System.out.println(" per pound");}
			if(names.length > 1) {
				System.out.print(names[1] + ": $");
				System.out.printf("%.2f", prices[1]);
				System.out.println(" per pound");}
			if(names.length > 2) {
				System.out.print(names[2] + ": $");
				System.out.printf("%.2f", prices[2]);
				System.out.println(" per pound");}
			
			Random ranGen = new Random(100);

			for (i = 3; i < names.length; i++) {
				names[i] = "Cheese Type " + (char)('A' + i);
				prices[i] = ranGen.nextInt(1000)/100.0;
				amounts[i] = 0;

				System.out.print(names[i] + ": $");
				System.out.printf("%.2f", prices[i]);
				System.out.println(" per pound");
			}
		}
		System.out.print("\n");
			
		}
		
		
		
		

	
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		
		for(int i = 0; i < names.length; i++) {
			System.out.print("Enter the amount of " + names[i] + " in lbs: " );
			double amountDesired = sc.nextDouble();

			while((amountDesired < 0) | (amountDesired % 0.5) != 0) {


				if(amountDesired < 0) {
					while(amountDesired < 0) {
						System.out.print("Invalid Input. Please enter a number greater than 0: ");
						amountDesired = sc.nextDouble();
						amounts[i] = amountDesired;
					}
				}

				if((amountDesired % 0.5) != 0) {
					while((amountDesired % 0.5) != 0) {
						System.out.print("Invalid Input. Please enter a number in quantities of 0.5: ");
						amountDesired = sc.nextDouble();
						amounts[i] = amountDesired;
					}
				}
			}
			amounts[i] = amountDesired;
		}
			
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		
		
		double amountsSum = 0;
		for(int i = 0; i < amounts.length; i++) {
			amountsSum += amounts[i];
		}
		
		if(amountsSum != 0) {
			System.out.println("\n----------------------------");
			for (int i = 0; i < names.length; i++) {
				if(amounts[i] != 0) {
					System.out.println(amounts[i] + " lb of " + names[i] + " @ $");
					System.out.printf("%.2f", prices[i]);
					System.out.println(" = $" + (prices[i] * amounts[i]));
				}
			}
			System.out.println("\n----------------------------");
		}
		else {
				System.out.println("No Items Were Purchased.");
		}	
	}
	
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		// Fix
		double oSubTotal = 0;
		for (int i = 0; i < prices.length; i++) {
			if(amounts[i] != 0) {
				oSubTotal += (prices[i]*amounts[i]);}}
		return oSubTotal;
		
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		// Fix
		
		double[] discounts = new double[2];

		discounts[0] = (((int)(amounts[0]/0.5)/2) * 0.5) * 25;
		discounts[1] = (((int)(amounts[1]/0.5)/3) * 0.5) * 40.50;
		return discounts;
	
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix
		System.out.println("Original Sub Total:\t\t\t+$ " + subTotal);
		System.out.println("Specials...");
		if(disSpecials[0] > 0) {
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): \t-$ ");
			System.out.printf("%.2f", disSpecials[0]);}
		if(disSpecials[1] > 0) {
			System.out.println("RedHawk (Buy 2 Get 1 Free):\t\t-$ ");
			System.out.printf("%.2f", disSpecials[1]);}
		double nSubTotal = (subTotal - disSpecials[0] - disSpecials[1]);
		System.out.println("New Sub Total:\t\t\t\t+$ ");
		System.out.printf("%.2f", nSubTotal);


		
		return nSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
		if(newSubTotal > 250) {
			System.out.println("Additional 15% Discount:\t\t-$ ");
			System.out.printf("%.2f", newSubTotal * 0.15);
			System.out.println("Final Total: \t\t\t\t+$ ");
			System.out.printf("%.2f", newSubTotal * 0.85);
		}
		else if(newSubTotal > 150) {
			System.out.println("Additional 10% Discount:\t\t-$ ");
			System.out.printf("%.2f", newSubTotal * 0.10);
			System.out.println("Final Total: \t\t\t\t+$ ");
			System.out.printf("%.2f", newSubTotal * 0.90);
		}

		else {
			System.out.println("No Additional Discount:\t\t\t-$ 0.00");
			System.out.println("Final Total: \t\t\t\t+$ ");
			System.out.printf("%.2f", newSubTotal);
		}

	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}