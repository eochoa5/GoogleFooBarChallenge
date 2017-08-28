package Google;
import java.util.ArrayList;
import java.util.Arrays;

public class Answer {   
	
	public static void main(String[] args){
		
		System.out.println(Arrays.toString(answer(15324)));
		
		
	}
	
	public static int largestPerfectSquare(int n){      
        if (Math.sqrt(n) % 1 ==0)      
          return n;      
        else      
          return largestPerfectSquare(n-1);      
  } 
	
	
    public static int[] answer(int area) { 
    	ArrayList<Integer> listOfAreas = new ArrayList<Integer>();
   
    	int high = area;
    	int largest = largestPerfectSquare(high);
    	listOfAreas.add(largest);
		
		int diff = high - largest;

    	while(diff != 0){
    	
    		high = diff;
			largest = largestPerfectSquare(high); 
			listOfAreas.add(largest);
			diff = high - largest;
    	
    	}
    	
        int[] ans = new int[listOfAreas.size()];
    	for(int i=0; i < listOfAreas.size(); i++){
    		
    		ans[i] = listOfAreas.get(i);
    	}
    	
    	return ans;

    } 
}
