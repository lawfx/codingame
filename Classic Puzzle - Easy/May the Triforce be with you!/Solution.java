import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int lineLength = 2*N;
        
        int stars = 1;        
        for(int i = 0;i < N;i++){
        	for(int j=0;j<lineLength - stars;j++){
        		if(i == 0 && j == 0){
        			System.out.print(".");
        		}
        		else{
        			System.out.print(" ");
        		}
        	}
        	for(int j=0;j<stars;j++){
        		System.out.print("*");
        	}
        	System.out.println();
        	stars+=2;
        	lineLength++;
        }
        stars = 1;
        int startSpace = N-1;
        int middleSpace = 2*N-1;
        for(int i = 0;i<N;i++){
        	for(int j=0;j<startSpace;j++){
        		System.out.print(" ");
        	}
        	for(int j=0;j<stars;j++){
        		System.out.print("*");
        	}
        	for(int j=0;j<middleSpace;j++){
        		System.out.print(" ");
        	}
        	for(int j=0;j<stars;j++){
        		System.out.print("*");
        	}
        	System.out.println();
        	stars+=2;
        	startSpace--;
        	middleSpace-=2;
        }
    }
}
