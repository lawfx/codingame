import java.util.*;

public class Solution {

	private int array[][];
 
    public void sort(int[][] inputArr , int from, int to, boolean first) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        quickSort(from, to, first);
    }
 
    private void quickSort(int lowerIndex, int higherIndex, boolean first) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2][0];
        if(!first){
        	pivot = array[lowerIndex+(higherIndex-lowerIndex)/2][1];
        }
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
        	if(first){
	            while (array[i][0] < pivot) {
	                i++;
	            }
	            while (array[j][0] > pivot) {
	                j--;
	            }
        	}
        	else{
        		 while (array[i][1] < pivot) {
 	                i++;
 	            }
 	            while (array[j][1] > pivot) {
 	                j--;
 	            }
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
            quickSort(lowerIndex, j, first);
        if (i < higherIndex)
            quickSort(i, higherIndex, first);
    }
 
    private void exchangeNumbers(int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
    public static void main(String args[]) {
       
    	Scanner in = new Scanner(System.in);
    	Solution sorter = new Solution();
        int N = in.nextInt();
        
        int[][] exp = new int[N][2];
      
        for (int i = 0; i < N; i++) {
            exp[i][0] = in.nextInt();
            exp[i][1] = exp[i][0] + in.nextInt();
        }
        
        sorter.sort(exp, 0, N-1, true);
        
        int pivot = exp[0][0];
        int index = 0;
        for(int i=1;i<N;i++){
        	if(pivot != exp[i][0]){
        		sorter.sort(exp, index, i - 1, false);
        		pivot = exp[i][0];
        		index = i; 
        	}
        }
        
        ArrayList<int[]> mins = new ArrayList<int[]>();
        pivot = exp[0][0];
        index = 0;
        mins.add(new int[]{exp[index][0], exp[index][1], 0});
        for(int i=1;i<N;i++){
        	if(exp[i][0] != pivot){
        		mins.add(new int[]{exp[i][0], exp[i][1], 0});
        		pivot = exp[i][0];
        		index = i;
        	}
        }
        
        for(int i=0;i<mins.size();i++){
        	int covers = 0;
        	for(int j = i+1;j<mins.size();j++){
        		if(mins.get(i)[1] > mins.get(j)[0]){
        			covers++;
        		}
        		else{
        			break;
        		}
        	}
        	mins.get(i)[2] = covers;
        }
        
        int calculations = 0;
        int lastPrevYesIndex = mins.size();
        for(int i=mins.size()-1;i>=0;i--){
        	if(mins.get(i)[2] < lastPrevYesIndex - i){
        		calculations++;
        		lastPrevYesIndex = i;
        	}
        }
        System.out.println(calculations);
    }
}
