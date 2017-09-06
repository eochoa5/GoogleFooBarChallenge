package Google;

public class QueueToDo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(answer(17, 4));
	}
	
	public static int answer(int start, int length) {

        int ans = 0, index=0;
        
        while (index < length) {
        	int a = length - index;
            ans ^= XOR(start, start + a);
            start += length;
            index++;
        }

        return ans;
    }

    public static int XOR(int start, int end) {
        int a = 0;

        for (int i = start; i < end; i++){
            a ^= i;
        }

        return a;
    }

}
