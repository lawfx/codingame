import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int min = Integer.MAX_VALUE;
        String minTime = "";
        for(int i=0;i<N;i++){
        	String temp = in.next();
        	String[] parts = temp.split(":");
        	int time = Integer.parseInt(parts[0])*3600 + Integer.parseInt(parts[1])*60 + Integer.parseInt(parts[2]);
        	if(time < min){
        		min = time;
        		minTime = temp;
        	}
        }
        System.out.println(minTime);
    }
}
