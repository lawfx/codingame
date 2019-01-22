import java.util.*;

public class Solution {

	private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
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
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Solution sorter = new Solution();
        int N = in.nextInt();
        int C = in.nextInt();
        
        int[] budgets = new int[N];
        int[] contributions = new int[N];
        
        int maxBudget = 0;
        for(int i=0;i<N;i++){
        	budgets[i] = in.nextInt();
        	maxBudget += budgets[i];
        }
        
        if(maxBudget < C){
        	System.out.println("IMPOSSIBLE");
        }
        else{
        	int median = C/N;
        	sorter.sort(budgets);
        	int raised = 0;
        	int contrCnt = 0;
        	
        	while(median > budgets[contrCnt]){
        		for(int i=contrCnt;i<N;i++){
        			if(budgets[i] <= median){
        				contributions[i] = budgets[i];
            			raised += contributions[i];
            			contrCnt++;
        			}
        			else{
        				break;
        			}
            	}
        		median = (C - raised) / (N - contrCnt);
        	}
        	
        	for(int i = contrCnt;i<N;i++){
        		contributions[i] = median;
        		raised += median;
        	}
        	
        	int diff = C - raised;
        	while(diff > 0){
        		for(int i = N-1;i>=contrCnt;i--){
        			if(budgets[i] >= contributions[i]+1 && diff > 0){
        				contributions[i]++;
        				diff--;
        			}
        			else{
        				contrCnt = i;
        				break;
        			}
        		}
        	}
        	
        	for(int i=0;i<N;i++){
        		System.out.println(contributions[i]);
        	}
        }
	}
}
