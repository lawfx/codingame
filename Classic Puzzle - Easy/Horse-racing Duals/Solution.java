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
            while (array[i] > pivot) {
                i++;
            }
            while (array[j] < pivot) {
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
	    int N = in.nextInt();
		Solution sorter = new Solution();
	    
	    int[] horses = new int[N];
	    
	    for(int i=0;i<N;i++){
	    	horses[i] = in.nextInt();
	    }
	    sorter.sort(horses);
	    
	    int closest = Integer.MAX_VALUE;
	    for(int i=0;i<N;i++){
	    	for(int j=i+1;j<N;j++){
	    		if(Math.abs(horses[i] - horses[j]) < closest){
	    			closest = Math.abs(horses[i] - horses[j]);
	    		}
	    		else if(horses[i] - horses[j] > 0 && horses[i] - horses[j] > closest){
	    			break;
	    		}
	    	}
	    }
	    System.out.println(closest);
    }
}
