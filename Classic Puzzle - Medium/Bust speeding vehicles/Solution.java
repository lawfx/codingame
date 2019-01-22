import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        double limit = (double) in.nextInt() / 3600;
        int nums = in.nextInt();
        
        String[] plates = new String[nums];
        int[] kms = new int[nums];
        long[] seconds = new long[nums];
        
        for(int i=0; i<nums; i++){
        	plates[i] = in.next();
        	kms[i] = in.nextInt();
        	seconds[i] = in.nextLong();
        }
        
        String platePivot = plates[0];
        int kmPivot = kms[0];
        long secondsPivot = seconds[0];
        boolean foundOne = false;
        for(int i=1;i<nums;i++){
        	if(platePivot.equals(plates[i])){
        		int diffKm = kms[i] - kmPivot;
        		long diffSeconds = seconds[i] - secondsPivot;
        		if(limit < (double) diffKm / diffSeconds){
        			System.out.println(plates[i] + " " + kms[i]);
        			foundOne = true;
        		}
        		kmPivot = kms[i];
        		secondsPivot = seconds[i];
        	}
        	else{
        		platePivot = plates[i];
        		kmPivot = kms[i];
        		secondsPivot = seconds[i];
        	}
        }
        if(!foundOne){
        	System.out.println("OK");
        }
    }
}
