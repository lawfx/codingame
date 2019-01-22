import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int[] list = new int[N];
        
        for(int i=0;i<N;i++){
        	list[i] = in.nextInt();
        }
        
        int steps = 0;
        int lastIndex = list.length - 1;
        for(int i = 0; i<N; i++){
        	if(list[i] == 0){
        		for(int j=lastIndex;j>i;j--){
        			if(list[j] == 1){
        				lastIndex = j;
        				steps++;
        				list[i] = 1;
        				list[j] = 0;
        				break;
        			}
        		}
        	}
        }
        System.out.println(steps);
    }
}
