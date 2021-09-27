import java.util.*;
public class shop {

	public static boolean isSetup;
	public static boolean didBuy;
	public static double originalSubt;
	public static double additionalDiscountamount;
	public static double additionalDiscountrate;

	public static String[] nameArr;
	public static double[] perpackArr;
	public static int[] dealsArr;
	public static int[] customerOrderSlip;


	public static void initialInterface() {
		isSetup = false;
		System.out.print("This program supports 4 functions \n"
				+ "\t1. Set Up Shop\n"
				+ "\t2. Buy\n"
				+ "\t3. List Items\n"
				+ "\t4. Checkout\n"
				+ "Please choose the function you want: ");
		Scanner input = new Scanner(System.in);
		int optionPicked = input.nextInt();
		if (optionPicked > 0 && optionPicked < 5) {
			optionpickedProcessing(optionPicked, input);
		}


		else {
			while(optionPicked < 1 || optionPicked > 4) {
				System.out.print("I do not recognize this command please try again.");
				optionPicked = input.nextInt();
				optionpickedProcessing(optionPicked, input);}}

	}
	public static void Interface() {
		System.out.print("This program supports 4 functions \n"
				+ "\t1. Set Up Shop\n"
				+ "\t2. Buy\n"
				+ "\t3. List Items\n"
				+ "\t4. Checkout\n"
				+ "Please choose the function you want: ");
		Scanner input = new Scanner(System.in);
		int optionPicked = input.nextInt();
		if (optionPicked > 0 && optionPicked < 5) {
			optionpickedProcessing(optionPicked, input);
		}


		else {
			while(optionPicked < 1 || optionPicked > 4) {
				System.out.print("I do not recognize this command please try again.");
				optionPicked = input.nextInt();
				optionpickedProcessing(optionPicked, input);}}

	}


	public static void setupShop(Scanner input) {
		System.out.print("Please enter the number of items to setup shop: ");
		int itemsinShop = input.nextInt();
		System.out.print("\n");
		creatingProducts(input, itemsinShop);



	}
	

	public static void creatingProducts(Scanner input, int itemsinShop) {

		nameArr = new String[itemsinShop];
		perpackArr = new double[itemsinShop];
		dealsArr = new int[itemsinShop];

		for(int i = 0; i < itemsinShop; i++) {
			System.out.print("Enter the name of the "+ numSuffix(i+1) + " product: ");
			input.nextLine();
			nameArr[i] = input.nextLine();
			System.out.print("Enter the per package price of " + nameArr[i] + ": ");
			perpackArr[i] = input.nextDouble();
			System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free)\nfor " + nameArr[i] + ", or 0 is no Special Discount offered: ");
			dealsArr[i] = input.nextInt();
		}


		System.out.print("\nEnter the amount required to qualify for Additional Discount (or 0 if none offered): ");
		additionalDiscountamount = input.nextDouble();
		if (additionalDiscountamount != 0) {
			isSetup = true;
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			additionalDiscountrate = input.nextDouble();
			checkAdditionalDiscount(input);
			Interface();}
		else {
			System.out.print("\n");
			isSetup = true;
			Interface();
		}
	}
	public static double checkAdditionalDiscount(Scanner input) {

		while(additionalDiscountrate < 0 || additionalDiscountrate >= 0.5) {
			System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
			additionalDiscountrate = input.nextDouble();
			System.out.print("\n");
			if(additionalDiscountrate < 0 || additionalDiscountrate >= 0.5)
				checkAdditionalDiscount(input);
		}

		return additionalDiscountrate;
	}
	public static void Buy(Scanner input) {
		customerOrderSlip = new int[nameArr.length];
		System.out.print("\n");
		for(int i = 0; i < nameArr.length; i++) {
			System.out.print("Enter the number of " + nameArr[i] + " packages to buy: ");
			customerOrderSlip[i] = input.nextInt();
			while(customerOrderSlip[i] < 0) {
				while(customerOrderSlip[i] < 0) {
					System.out.print("Invalid input. Enter a value >= 0: ");
					customerOrderSlip[i] = input.nextInt();
				}
			}
		}
		System.out.print("\n");
		didBuy = true;

	}
	public static void listItems() {
		System.out.print("\n");
		int summingOrders = 0;
		for(int i = 0; i < customerOrderSlip.length; i++) {
			summingOrders += customerOrderSlip[i];}
		
		if (summingOrders != 0) {
			for(int i = 0; i < nameArr.length; i++) {
				if(customerOrderSlip[i] != 0) {
					System.out.print(customerOrderSlip[i] + " packages of " + nameArr[i] + " @ $");
					System.out.printf("%.2f", perpackArr[i]);
					System.out.print(" per pkg = $");
					System.out.printf("%.2f", (customerOrderSlip[i]*perpackArr[i]));
					System.out.print("\n");
					originalSubt += customerOrderSlip[i]*perpackArr[i];
				}}}
			else System.out.println("No items were purchased.");
			System.out.print("\n");
	}
	public static void Checkout(Scanner input) {
		System.out.print("\nOriginal Sub Total:\t$");
		System.out.printf("%.2f", originalSubt);
		System.out.print("\n");
		if (discountSpecials() != 0) {
		System.out.print("Special Discounts:\t$");
		System.out.printf("%.2f", discountSpecials());
		System.out.print("\n");
		}
		else {
			System.out.println("No Specials Discounts applied");}
		System.out.print("New Sub Total:\t\t$");
		System.out.printf("%.2f", (originalSubt-discountSpecials()));
		System.out.print("\n");
		if(additionalDiscountamount == 0) {
			System.out.println("You did not qualify for an Additional Discount");
			System.out.print("Final Sub Total:\t$");
			System.out.printf("%.2f", (originalSubt-discountSpecials()));
			System.out.print("\n\n");
			byeBye(input);
		}else if ((originalSubt-discountSpecials()) > additionalDiscountamount) {
			System.out.print("Additional " + (additionalDiscountrate*100) + "% Discount:\t");
			System.out.printf("%.2f", ((originalSubt-discountSpecials())*(additionalDiscountrate)));
			System.out.print("\n");
			System.out.println("Final Sub Total:\t$");
			System.out.printf("%.2f", ((originalSubt-discountSpecials())*(1-additionalDiscountrate)));
			System.out.print("\n\n");
		}
		else {
			System.out.println("Something went wrong. Shop is restarting...");
			Interface();
		}
		
	}
	
	public static void byeBye(Scanner input) {
		System.out.print("Thanks for coming!\n\n----------------------------------\n Would you like to re-run (1 for yes, 0 for no)? ");
		int ReRun = input.nextInt();
		if (ReRun == 1) {
			System.out.println("----------------------------------\n");
			initialInterface();
		}else {
			System.out.println("----------------------------------\n");
		}
		
	}

	public static double discountSpecials(){
		double calculatedDiscount = 0;
		double[] discounts = new double[nameArr.length];
		
		for(int i = 0; i < nameArr.length; i++) {
			if(dealsArr[i] != 0 ) discounts[i] = (int)(customerOrderSlip[i]/(dealsArr[i]+1)) * perpackArr[i];
		}
		for(int i = 0; i < nameArr.length; i++) {
			calculatedDiscount += discounts[i];
		}
		
		return calculatedDiscount;
	
	}
	public static void optionpickedProcessing(int optionPicked, Scanner input) {

		if(optionPicked == 1) {
			setupShop(input);}
		else if(optionPicked == 2) {
			if (isSetup == true) Buy(input);
			else System.out.println("\nShop is not set up yet!\n");
			Interface();}
		else if(optionPicked == 3) {
			if (isSetup == true) {
				if (didBuy == true) listItems();
				else System.out.println("\nYou have not bought anything!\n");}
			else System.out.println("\nShop is not set up yet!\n");
			Interface();}
		else if(optionPicked == 4){
			if (isSetup == true) Checkout(input);
			else System.out.println("\nShop is not set up yet!\n");
			Interface();}
		else {
			while(optionPicked < 1 || optionPicked > 4) {
				System.out.print("I do not recognize this command please try again.");
				optionPicked = input.nextInt();
				optionpickedProcessing(optionPicked, input);}}}

	public static String numSuffix(int i) {
		int rem = i% 10;
		switch(rem) {
		case 0:
		case 4:
		case 5: 
		case 6:
		case 7:
		case 8:
		case 9:
			return(i+ "th");
		case 1:
			if(i% 100 != 11)
				return(i+ "st");
			else
				return(i+ "th");
		case 2:
			if(i% 100 != 12)
				return(i+ "nd");
			else
				return(i+ "th");
		case 3:
			if(i% 100 != 13)
				return(i+ "rd");
			else
				return(i+ "th");
		default:
			break;
		}
		return"";
	}



	public static void main(String[] args) {
		initialInterface();
		
	}
}
