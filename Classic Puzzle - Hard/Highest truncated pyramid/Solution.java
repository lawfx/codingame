import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int bricks = in.nextInt();
        
          boolean foundNum = false;
          int start = 0;
          while(!foundNum){
        	  start++;
        	  foundNum = isStartNum(start , bricks);
          }
          int sum = start;
          while(sum <= bricks){
        	  for(int i=0;i<start;i++){
        		  System.out.print("*");
        	  }
        	  System.out.println();
        	  start++;
        	  sum += start;
          }
    }
    
    static boolean isStartNum(int start, int bricks){
    	
    	int sum = start;
    	int nextRow = start + 1;
    	while(sum + nextRow <= bricks){
    		sum += nextRow;
    		nextRow++;
    	}
    	if(sum == bricks){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}
