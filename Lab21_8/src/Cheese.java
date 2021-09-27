import java.util.Scanner;

public class Cheese {
	
	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;
	
	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as paramter
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 parameters
		this.name = name;
		this.price = price;
		this.amount = 0;
		numCheese++;
	}

	public String getName() { // Accessor
		return name;
	}

	public void setName(String newName) { // Mutator 
		name = newName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(Scanner input) {
		double amountDesired = input.nextDouble();
		
		while((amountDesired < 0) | (amountDesired % 0.5) != 0) {

			
			if(amountDesired < 0) {
				while(amountDesired < 0) {
					System.out.print("Invalid Input. Please enter a number greater than 0: ");
					amountDesired = input.nextDouble();
					amount = amountDesired;
				}
			}

			if((amountDesired % 0.5) != 0) {
				while((amountDesired % 0.5) != 0) {
					System.out.print("Invalid Input. Please enter a number in quantities of 0.5: ");
					amountDesired = input.nextDouble();
					amount = amountDesired;
				}
				
			}
			
		}
		
		amount = amountDesired;
	}
	

}


