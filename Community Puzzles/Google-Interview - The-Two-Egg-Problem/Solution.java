import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int floors = in.nextInt();
        
        int worstCase = (int) Math.floor((1 + Math.sqrt(2*4*floors))/2);
        System.out.println(worstCase);
    }
}
