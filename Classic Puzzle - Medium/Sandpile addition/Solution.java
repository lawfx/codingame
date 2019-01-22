import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int[][] sandPile = new int[N][N];
        for(int i = 0;i<N;i++){
        	sandPile[i] = piles(in.next());
        }
        for(int i=0;i<N;i++){
        	int[] temp = piles(in.next());
        	for(int j=0;j<N;j++){
        		sandPile[i][j] += temp[j];
        	}
        }
        boolean allGood = false;
        while(!allGood){
        	allGood = true;
	        for(int i=0;i<N;i++){
	        	for(int j=0;j<N;j++){
	        		if(sandPile[i][j] > 3){
	        			allGood = false;
	        			sandPile[i][j] -= 4;
	        			shiftGrains(sandPile, N, i,j);
	        		}
	        	}
	        }
        }
        for(int i=0;i<N;i++){
        	for(int j=0;j<N;j++){
        		System.out.print(sandPile[i][j]);
        	}
        	System.out.println();
        }
    }
    
    static void shiftGrains(int[][] pile, int max, int i, int j){
    	
    	if(i - 1 >= 0){
    		pile[i-1][j] += 1;
    	}
    	if(i + 1 < max){
    		pile[i+1][j] += 1;
    	}
    	if(j - 1 >= 0){
    		pile[i][j-1] += 1;
    	}
    	if(j + 1 < max){
    		pile[i][j+1] += 1;
    	}
    }
    
    static int[] piles(String row){
    	
    	int[] pile = new int[row.length()];
    	
    	for(int j=0;j<row.length();j++){
    		pile[j] = Integer.parseInt(row.substring(j, j+1));
    	}
    	
    	return pile;
    	
    }
}
