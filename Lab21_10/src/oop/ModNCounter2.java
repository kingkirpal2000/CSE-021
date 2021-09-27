package oop;

public class ModNCounter2 extends Counter{

	private int CycleLength;
	
	
	public ModNCounter2 (int n) {
		CycleLength = n; 
		
	}
	
	public int value(){
		
		int CycledValue = super.value() % CycleLength;
		return CycledValue;
		
	}
	
	
	
	
	
	
	
	
	
	
}
