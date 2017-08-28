package Google;

import java.util.Arrays;

public class GearingUpForDestruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] pegs = {4, 17, 50};
		
		System.out.println(Arrays.toString(answer(pegs)));
		
		double d = 1.298769;
		float f = (float)d;
		//System.out.println(d);

	}
	
	public static int[] answer(int[] pegs) {

        int a = pegs[0], r=-1,b;
        
        for(int i = 0; i < pegs.length; i++) {
            a += 2 * pegs[i] * r;
            r *= -1;
        }
        a += pegs[pegs.length-1] * r;
        a *= 2;
        
        if(pegs.length%2!=0){b=1;
        }else{b=3;}
        
        if(a%b==0) {
            a = a/b;
            b = 1;
        }

        double prev = (1d * a) / (1d * b);
        for(int i = 0; i < pegs.length - 2; i++) {
            int width = pegs[i+1] - pegs[i];
            if(prev > (width-1) || prev < 0) {
            	return new int[] {-1, -1};
            }
            prev = width - prev;
        }

        return new int[] {a, b};
    }

}
