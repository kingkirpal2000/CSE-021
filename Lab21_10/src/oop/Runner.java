package oop;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		 testModNCounter2();

		 testDecrementableCounter();

		 testSeasonCounter();
	}
	
	public static void testModNCounter2() {
		ModNCounter2 ctr = new ModNCounter2(3);
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
		
	}

	
	public static void testCounter() {
		System.out.println("-- Testing Counter");

		Counter c = new Counter();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());

	}

	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- Testing 7 statements");
		c.increment();
		c.increment();
		c.increment();
		c.increment();
		c.reset();
		c.reset();
		c.reset();
		c.reset();
		c.reset();
		c.reset();
		c.reset();
		c.increment();
		c.increment();
		c.increment();

		System.out.println("Current value: " + c.value());
	}
	
	public static void testDecrementableCounter() {
		DecrementableCounter c = new DecrementableCounter();
		System.out.println("-- Testing Decrement");
		c.increment();
		c.increment();
		c.increment();
		
		System.out.println("Current value: " + c.value());
		c.decrement();
		System.out.println("Current value: " + c.value());
	}

	public static void testSeasonCounter() {
		SeasonCounter c = new SeasonCounter();
		System.out.println("-- Testing Season Counter");
		System.out.println("Current value: " + c.toString());
		c.increment();
		System.out.println("Current value: " + c.toString());
		c.increment();
		System.out.println("Current value: " + c.toString());
		c.increment();
		System.out.println("Current value: " + c.toString());
		c.increment();
		System.out.println("Current value: " + c.toString());
		c.increment();
		System.out.println("Current value: " + c.toString());

		
	}
}
