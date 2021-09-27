
public class FindDuplicateCount {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2};
		
		
		
		int foundValue;
		
	
		for(int i = 0; i < arr.length; i++) {
			int occurences = 0; 
			
			foundValue = arr[i];
			
			for(int j = i + 1; j < arr.length; j++) {
				
				if (arr[j] == foundValue) {
					occurences++;
				}
				
			}
			
			if (occurences != 0) {
		
				System.out.println("There are " + occurences + " more occurrences of value " + foundValue + " starting at index " + i);
				
			}
			else { 
				System.out.println("There are no duplicates with value " + foundValue + " beyond index " + i);
			}
				
			
			
			
			
		}
				
				
				
	
		
		
	}

}
