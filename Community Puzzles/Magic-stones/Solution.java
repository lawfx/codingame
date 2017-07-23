import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        ArrayList<Integer> stones = new ArrayList<Integer>();
        for(int i=0;i<N;i++){
        	stones.add(in.nextInt());
        }
        
        boolean allGood = false;
        while(!allGood){
        	allGood = true;
        	Collections.sort(stones);
        	int pivot = stones.get(0);
        	for(int i=1;i<stones.size();i++){
        		if(stones.get(i) == pivot){
        			stones.add(stones.get(i) + 1);
        			stones.remove(i);
        			stones.remove(i-1);
        			allGood = false;
        			break;
        		}
        		pivot = stones.get(i);
        	}
        }
        System.out.println(stones.size());
    }
}
