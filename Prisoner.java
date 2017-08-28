package Google;

import java.math.BigInteger;

public class Prisoner {

	public static void main(String[] args) {
		
		
		System.out.println(answer(5,10));
		
	}
	
	
	
public static String answer(int x, int y){
		
	BigInteger ans = new BigInteger("1"); 
    int a = 1, b=1;
    while (a < y) {
      ans = ans.add(new BigInteger(a+""));
      a++;
    }
    
    a++;
    
    while (b < x) {
      ans = ans.add(new BigInteger(a+""));
      b++;
      a++;
    }
    return ans.toString();
	

	}


	
	
	

}
