import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		System.out.print("Enter the number of Cheeses for shop setup: ");
		Scanner input = new Scanner(System.in);



		final int MAXCHEESE = input.nextInt();

		String[] names = new String[MAXCHEESE+2];
		double[] prices = new double[MAXCHEESE+2];
		double[] amounts = new double[MAXCHEESE+2];

		// Three Special Cheeses
		if(MAXCHEESE > 0) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}if(MAXCHEESE > 1) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if(MAXCHEESE > 2) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}
		System.out.println("\n\nWe sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages):");

		if(MAXCHEESE > 0) {
			System.out.println(names[0] + ": $" + df.format(prices[0]) + " per pound");}
		if(MAXCHEESE > 1) {
			System.out.println(names[1] + ": $" + df.format(prices[1]) + " per pound");}
		if(MAXCHEESE > 2) {
			System.out.println(names[2] + ": $" + df.format(prices[2]) + " per pound");}

		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + df.format(prices[i]) + " per pound");
		}
		System.out.print("\n");


		for(int i = 0; i < MAXCHEESE; i++) {
			System.out.print("Enter the amount of " + names[i] + " in lbs: " );
			double amountDesired = input.nextDouble();

			while((amountDesired < 0) | (amountDesired % 0.5) != 0) {


				if(amountDesired < 0) {
					while(amountDesired < 0) {
						System.out.print("Invalid Input. Please enter a number greater than 0: ");
						amountDesired = input.nextDouble();
						amounts[i] = amountDesired;
					}
				}

				if((amountDesired % 0.5) != 0) {
					while((amountDesired % 0.5) != 0) {
						System.out.print("Invalid Input. Please enter a number in quantities of 0.5: ");
						amountDesired = input.nextDouble();
						amounts[i] = amountDesired;
					}
				}
			}
			amounts[i] = amountDesired;
		}


		System.out.print("\n");
		double amountsSum = 0;
		for(int i = 0; i < amounts.length; i++) {
			amountsSum += amounts[i];
		}

		//itemized listing
		double oSubTotal = 0;
		System.out.print("Would you like to see an itemized list of your order? (Press 1 for yes): ");
		if((input.nextInt() == 1) & (amountsSum != 0)) {
			System.out.println("\n----------------------------");
			for (int i = 0; i < MAXCHEESE; i++) {
				if(amounts[i] != 0) {
					System.out.println(amounts[i] + " lb of " + names[i] + " @ $" + df.format(prices[i]) + " = $" + df.format(prices[i] * amounts[i]));
					oSubTotal += (prices[i]*amounts[i]);

				}
			}
			System.out.println("\n----------------------------");
		}
		else {
			if(amountsSum == 0) {
				System.out.println("No Items Were Purchased.");
			}
		}

		double[] foundDiscounts = calculatedDiscounts(amounts[0], amounts[1]);

		//totaling
		System.out.println("Original Sub Total:\t\t\t+$ " + df.format(oSubTotal));
		System.out.println("Specials...");
		if(foundDiscounts[0] > 0) {
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): \t-$ " + df.format(foundDiscounts[0]));}
		if(foundDiscounts[1] > 0) {
			System.out.println("RedHawk (Buy 2 Get 1 Free):\t\t-$ " + df.format(foundDiscounts[1]));}
		double nSubTotal = (oSubTotal - foundDiscounts[0] - foundDiscounts[1]);
		System.out.println("New Sub Total:\t\t\t\t+$ " + df.format(nSubTotal));


		if(nSubTotal > 250) {
			System.out.println("Additional 15% Discount:\t\t-$ " + df.format(nSubTotal * 0.15));
			System.out.println("Final Total: \t\t\t\t+$ " + df.format(nSubTotal * 0.85));
		}
		else if(nSubTotal > 150) {
			System.out.println("Additional 10% Discount:\t\t-$ " + df.format(nSubTotal * 0.10));
			System.out.println("Final Total: \t\t\t\t+$ " + df.format(nSubTotal * 0.90));
		}

		else {
			System.out.println("No Additional Discount:\t\t\t-$ 0.00");
			System.out.println("Final Total: \t\t\t\t+$ " + df.format(nSubTotal));
		}


	}






	public static double[] calculatedDiscounts(double qHumboldt, double qredHawk) {

		double[] discounts = new double[2];

		discounts[0] = (((int)(qHumboldt/0.5)/2) * 0.5) * 25;
		discounts[1] = (((int)(qredHawk/0.5)/3) * 0.5) * 40.50;
		return discounts;

	}







}
