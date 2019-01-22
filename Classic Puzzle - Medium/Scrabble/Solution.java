import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    private String array[][];
	private int length;

	public void sort(String[][] inputArr, int low, int high) {
		
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		if(low==0 && high==0){
		quickSort(0, length - 1);
		}
		else{
			quickSort1(low, high);
		}
	}

	private void quickSort(int lowerIndex, int higherIndex) {
		
		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = Integer.parseInt(array[lowerIndex+(higherIndex-lowerIndex)/2][1]);
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (Integer.parseInt(array[i][1])>pivot) {
				i++;
			}
			while (Integer.parseInt(array[j][1])<pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}
	
	private void quickSort1(int lowerIndex, int higherIndex) {
		
		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = Integer.parseInt(array[lowerIndex+(higherIndex-lowerIndex)/2][2]);
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (Integer.parseInt(array[i][2])<pivot) {
				i++;
			}
			while (Integer.parseInt(array[j][2])>pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort1(lowerIndex, j);
		if (i < higherIndex)
			quickSort1(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		String temp = array[i][0];
		array[i][0] = array[j][0];
		array[j][0] = temp;
		temp = array[i][1];
		array[i][1] = array[j][1];
		array[j][1] = temp;
		temp = array[i][2];
		array[i][2] = array[j][2];
		array[j][2] = temp;
	}
	
	public static void main(String args[]) {
		Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[][] words = new String[N][3];
        for (int i = 0; i < N; i++) {
            words[i][0] = in.nextLine();
            String[] parts = words[i][0].split("");
            int points = 0;
            for(int j=0;j<parts.length;j++){
            	points+=sol.countPoints(parts[j]);
            }
            words[i][1]=Integer.toString(points);
            words[i][2]=Integer.toString(i);
        }
        sol.sort(words,0,0);
        
        int index=0;
        int start = 0;
        while(start<N){
        	int currpoints = Integer.parseInt(words[start][1]);
	        while(Integer.parseInt(words[index+1][1])==currpoints){
	        	index++;
	        	if(index+1==N){
	        		break;
	        	}
	        }
	        sol.sort(words,start,index);
	        start=index+1;
        }

       String LETTERS = in.nextLine();
       String[] parts = LETTERS.split("");
       String answer="";
       for(int i=0;i<N;i++){
    	   int cnt=0;
    	   String[] word = new String[parts.length];
    	   System.arraycopy( parts, 0, word, 0, parts.length );
    	   String[] partsdict = words[i][0].split("");
    	   for(int j=0;j<partsdict.length;j++){ //gia kathe gramma tou dict
    		   boolean flag=false;
    		   for(int k=0;k<word.length;k++){ //kai kathe gramma tis leksis
    			   if(partsdict[j].equals(word[k])){
    				   flag=true;
    				   cnt++;
    				   word[k]="";
    				   break;
    			   }
    		   }
    		   if(!flag){
    			   break;
    		   }
    	   }
    	   if(cnt==partsdict.length){
    		   answer = words[i][0];
    		   break;
    	   }
       }

       System.out.println(answer);
    }
	
	public int countPoints(String letter){
		if(letter.equals("e") || letter.equals("a") || letter.equals("i") || 
		   letter.equals("o") || letter.equals("n") || letter.equals("r") || 
		   letter.equals("t") || letter.equals("l") || letter.equals("s") || 
		   letter.equals("u")){
			return 1;
		}
		else if(letter.equals("d") || letter.equals("g")){
			return 2;
		}
		else if(letter.equals("b") || letter.equals("c") || letter.equals("m") || 
				letter.equals("p")){
			return 3;
		}
		else if(letter.equals("f") || letter.equals("h") || letter.equals("v") || 
				letter.equals("w") || letter.equals("y")){
			return 4;
		}
		else if(letter.equals("k")){
			return 5;
		}
		else if(letter.equals("j") || letter.equals("x")){
			return 8;
		}
		else{
			return 10;
		}
	}
}
