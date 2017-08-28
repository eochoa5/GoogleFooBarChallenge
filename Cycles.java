package Google;

import java.util.ArrayList;
import java.util.Arrays;

public class Cycles {
	static int count = 0;
	
public static void main(String[] args){
	

	System.out.println(answer("210022", 3));
	
		
}

public static String decimalToBase(long n, int b){
    
	StringBuilder sb = new StringBuilder("");
	
    while (n > 0){
        sb.insert(0, (n % b)+"");
        n  = n / b;
    }
    
    return sb.toString();

}

public static String baseToDecimal(long n, int b){
	  int x = 0;
	  
	  char[] c = (n+"").toCharArray();
	  
	  for (int i=0; i<c.length; i++){
	    x = b * x + Character.getNumericValue(c[i]);
	  }
	 
	    return x+"";
}

public static String getSubtract(long x, long y, int b){
	  if (b==10)
	    return (x-y)+"";
	    
	  long dx=Long.parseLong(baseToDecimal(x,b));
	  long dy=Long.parseLong(baseToDecimal(y,b));
	  long dz=dx-dy;
	  
	  return decimalToBase(dz, b);
			  
}


	public static int answer(String n, int b) {
		
		ArrayList<String> zv = new ArrayList<>();
		
		while(true){
			char[] chars1 = n.toCharArray();
			Arrays.sort(chars1);
			String sorted1 = new String(chars1);
			
			long y = Long.parseLong(sorted1);
			long x = Long.parseLong(new StringBuilder(sorted1).reverse().toString());
			String z = getSubtract(x,y,b);
			
			StringBuilder n2 = new StringBuilder(z+"");
			
			int length = n.length();
			int diff = length - n2.length();
			
			for(int i = 0; i<diff; i++){
				n2.insert(0, "0");
				
			}
			
			z = n2.toString();
			
			int index = 0;
			for (String s: zv){
		          if (s.equals(z)){
		        	  
		            return index + 1;
		           
		          }
		          index++;
			}
			
			zv.add(0,z);
	        n = z;
	        
			
		}
	
    } 

}
