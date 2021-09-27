import java.util.Random;
import java.util.Scanner;

public class Shop {

	Cheese HFog, RHawk, Teleme;

	/*
	 * Shop constructor initializes the 3 types of cheeses sold, along 
	 * with their prices.
	 */
	public Shop() {
		HFog = new Cheese();
		HFog.setName("Humboldt Fog");
		HFog.setPrice(25.00);

		RHawk = new Cheese("Red Hawk");
		RHawk.setPrice(40.50);

		Teleme = new Cheese("Teleme", 17.25);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase. 
	 */
	private void intro(Scanner input) {
		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println(HFog.getName() + ": $" + HFog.getPrice() + " per pound");
		System.out.println(RHawk.getName() + ": $" + RHawk.getPrice() + " per pound");
		System.out.println(Teleme.getName() + ": $" + Teleme.getPrice() + " per pound");

		System.out.print("\nEnter the amount of " + HFog.getName() + " in lbs: ");
		HFog.setAmount(input);
		System.out.print("Enter the amount of " + RHawk.getName() + " in lbs: ");
		RHawk.setAmount(input);
		System.out.print("Enter the amount of " + Teleme.getName() + " in lbs: ");
		Teleme.setAmount(input);
		
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	private void itemizedList(){
		double amt = 0, price = 0;
		if ((HFog.getAmount() + RHawk.getAmount() + Teleme.getAmount()) == 0)
			System.out.println("No items were purchased.");
		else {
			if ((amt = HFog.getAmount()) > 0) {
				price = HFog.getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, HFog.getName(), price, price*amt);
				if ((amt = RHawk.getAmount()) > 0) {
					price = RHawk.getPrice();
					System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, RHawk.getName(), price, price*amt);
					if ((amt = Teleme.getAmount()) > 0) {
						price = Teleme.getPrice();
						System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, Teleme.getName(), price, price*amt);
						
					}
				}
			}
			
		}
	}

	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	private double calcSubTotal() {
		double subTotal = 0;
		subTotal += HFog.getAmount() * HFog.getPrice();
		subTotal += RHawk.getAmount() * RHawk.getPrice();
		subTotal += Teleme.getAmount() * Teleme.getPrice();
		
		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 * Minor changes from Lab 04 (identical logic). 
	 */
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};
		
		double hfAmt = HFog.getAmount(), rhAmt = RHawk.getAmount();
		
		if (hfAmt > 0) {
			disSpecials[0] = (((int)(hfAmt/0.5)/2) * 0.5) * 25;
		}
		
		if(rhAmt > 0) {
			disSpecials[1] = (((int)(rhAmt/0.5)/3) * 0.5) * 40.50;
		}
		
		return disSpecials;		
	}
	
	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total. Identical to Lab 04.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		System.out.println("\nOriginal Sub Total:\t\t\t+$ " + subTotal);
		System.out.println("Specials...");
		if(disSpecials[0] > 0) {
			System.out.print("Humboldt Fog (Buy 1 Get 1 Free): \t-$ ");
			System.out.printf("%.2f", disSpecials[0]);}
		if(disSpecials[1] > 0) {
			System.out.print("\nRedHawk (Buy 2 Get 1 Free):\t\t-$ ");
			System.out.printf("%.2f", disSpecials[1]);}
		if(disSpecials[0] + disSpecials[1] == 0) {
			System.out.print("None\t\t\t\t\t-$0.00");
		}
		double nSubTotal = (subTotal - disSpecials[0] - disSpecials[1]);
		System.out.print("\nNew Sub Total:\t\t\t\t+$ ");
		System.out.printf("%.2f", nSubTotal);


		
		return nSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total. Identical to Lab 04.
	 */
	private void printFinalTotal(double newSubTotal) {
		if (newSubTotal > 250) {
			System.out.print("\nAdditional 15% Discount: \t\t-$ ");
			System.out.printf("%.2f", (newSubTotal*0.15));
			System.out.print("\nFinal Total: \t\t\t\t+$ ");
			System.out.printf("%.2f", (newSubTotal*0.85));
		}
		else if (newSubTotal > 150) {
			System.out.print("\nAdditional 10% Discount: \t\t-$ ");
			System.out.printf("%.2f", (newSubTotal*0.10));
			System.out.print("\nFinal Total: \t\t\t\t+$ ");
			System.out.printf("%.2f", (newSubTotal*0.90));
		}
		else{
			System.out.print("\nAdditional 0% Discount: \t\t-$ 0.00");
			System.out.print("\nFinal Total: \t\t\t\t+$ " + newSubTotal);
		}
	}
	
		
	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		if ((amt = HFog.getAmount()) > 0) 
			System.out.println(amt + " lb of Humboldt Fog @ $0 = $" + 0);
		if ((amt = RHawk.getAmount()) > 0) 
			System.out.println(amt + " lb of Red Hawk @ $0 = $" + 0);
		if ((amt = Teleme.getAmount()) > 0) 
			System.out.println(amt + " lb of Teleme @ $0 = $" + 0);
		System.out.println("Total: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();
		
		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}
		
		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}
