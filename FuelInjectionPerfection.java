package Google;

import java.math.BigInteger;

public class FuelInjectionPerfection {

	public static void main(String[] args) {
		
		
		System.out.println(answer("3"));

	}
	
	public static int answer(String n) { 
		
		BigInteger input = new BigInteger(n);
        BigInteger two = new BigInteger("2");
        BigInteger one = BigInteger.ONE;
        BigInteger three = new BigInteger("3");
        int numOperations = 0;

        if (input.compareTo(one) < 0)
            return 0;
        
        if (input.equals(three))
            return 2;

        while (!input.equals(one)) {

            if (input.equals(three)) {
                numOperations += 2;
                break;
            }
            
            if (!input.mod(two).equals(BigInteger.ZERO)) {
            	
                BigInteger temp = input.add(one).divide(two).mod(two);

                if (!temp.equals(BigInteger.ZERO)) {
                    numOperations++;
                    input = input.subtract(one);
                } else {
                    numOperations++;
                    input = input.add(one);
                }
            }

            input = input.divide(two);
            numOperations++;
        }

        return numOperations;

    } 

}
