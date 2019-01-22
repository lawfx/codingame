import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int columns = in.nextInt();
        int rows = in.nextInt();
        
        String[][] map = new String[rows][columns];
        
        for(int i=0;i<rows;i++){
        	String row = in.next();
        	map[i] = row.split("");
        }
        
        boolean allGood = false;
        while(!allGood){
        	allGood = true;
	        for(int i=rows-2;i>=0;i--){
	        	for(int j=columns-1;j>=0;j--){
	        		if(map[i][j].equals("#") && map[i+1][j].equals(".")){
	        			allGood = false;
	        			map[i+1][j] = "#";
	        			map[i][j] = ".";
	        		}
	        	}
	        }
        }
        
        for(int i=0;i<rows;i++){
        	for(int j=0;j<columns;j++){
        		System.out.print(map[i][j]);
        	}
        	System.out.println();
        }
    }
}
