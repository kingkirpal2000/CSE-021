import java.util.Scanner;

public class CheeseShop {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println("Humboldt Fog: $25.00 per pound");
		System.out.println("Red Hawk: $40.50 per pound");
		System.out.println("Teleme: $17.25 per pound\n\n\n");
		
		double qHumboldt;
		double qredHawk;
		double qTeleme;
		
		boolean keepAsking = false;
		//Entering quantity of Humboldt
		System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		qHumboldt = input.nextDouble();
	
		while (qHumboldt % 0.5 != 0){
			System.out.print("Invalid input. Enter a vlaue that's multiple of 0.5: ");
			qHumboldt = input.nextDouble();}
		while (qHumboldt < 0) {
			System.out.print("Invalid input. Enter a vlaue that's multiple of 0.5: ");
			qHumboldt = input.nextDouble();
		}
		
		//Entering quantity of Red Hawk
		System.out.print("Enter the amount of Red Hawk in lbs: ");
		qredHawk = input.nextDouble();
		
		while (qredHawk % 0.5 != 0){
			System.out.print("Invalid input. Enter a vlaue that's multiple of 0.5: ");
			qredHawk = input.nextDouble();}
		while (qredHawk < 0) {
			System.out.print("Invalid input. Enter a vlaue that's multiple of 0.5: ");
			qredHawk = input.nextDouble();
		}
		
		//Entering quantity of Teleme
		System.out.print("Enter the amount of Teleme in lbs: ");
		qTeleme = input.nextDouble();
		
		while (qTeleme % 0.5 != 0){
			System.out.print("Invalid input. Enter a vlaue that's multiple of 0.5: ");
			qTeleme = input.nextDouble();}
		while (qTeleme < 0) {
			System.out.print("Invalid input. Enter a vlaue that's multiple of 0.5: ");
			qTeleme = input.nextDouble();
		}
		
		System.out.println("\n\n\n");
		//Ask for itemized list
		System.out.print("Would you like to view an itemized list? Press 1 for yes or any other number to proceed.");
		int likeView = input.nextInt();
		
		if (likeView == 1){
			System.out.print(displayList(qHumboldt, qredHawk, qTeleme));
		}
	
		
		System.out.println("Sub total: \t\t $" + ((qHumboldt*25.00)+(qredHawk*40.50)+(qTeleme*17.25)));
		System.out.println("Discounts...");
		
		double[] foundDiscounts = calculatedDiscounts(qHumboldt, qredHawk);
		
		
		if (foundDiscounts[0] != 0) {
			System.out.println("Humboldt Fog (Buy 1 get 1 free): -$" + foundDiscounts[0]);
		}
		
		if (foundDiscounts[1] != 0) {
			System.out.println("Red Hawk (Buy 2 get 1 free): -$" + foundDiscounts[1]);
		}
		if((foundDiscounts[0]+foundDiscounts[1]) == 0) {
			System.out.println("None: -$0.00");
		}
		
		double finalTotal = ((qHumboldt*25.00)+(qredHawk*40.50)+(qTeleme*17.25)-foundDiscounts[0]-foundDiscounts[1]);
		
		System.out.println("Final Total: $" + finalTotal);
		

	}
	
	public static String displayList(double qHumboldt, double qredHawk, double qTeleme) {
		
		String itemizedList = qHumboldt + " lb of Humboldt Fog @ $25.00 = $" + (qHumboldt * 25.00) + "\n" + qredHawk + " lb of Red Hawk @ $40.5 = $" + (qredHawk * 40.50) + "\n" + qTeleme + " lb of Teleme @ $17.25 = $" + (qTeleme * 17.25) + "\n\n\n";
		
		return itemizedList;
		
	}
	
	public static double[] calculatedDiscounts(double qHumboldt, double qredHawk) {
		
		double[] discounts = new double[2];
		
		discounts[0] = (((int)(qHumboldt/0.5)/2) * 0.5) * 25;
		discounts[1] = (((int)(qredHawk/0.5)/3) * 0.5) * 40.50;
		return discounts;
		
	}


}



