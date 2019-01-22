import java.util.*;

class Solution {

    private int array[];
	private int whenarray[];
	private int length;
	
public void sort(int[] inputArr,int[] whenArr) {
		
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		this.whenarray = whenArr;
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
		int temp2 = whenarray[i];
		whenarray[i] = whenarray[j];
		whenarray[j] = temp2;
	}

    public static void main(String args[]) {
        Solution sorter = new Solution();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] stocks = new int[n];
        int[] when = new int[n];
        for (int i = 0; i < n; i++) {
            stocks[i] = in.nextInt();
            when[i] = i;
        }
        sorter.sort(stocks,when);
        
        int maxloss = -1;
        int index=0;
        int lastindex=stocks.length-1;
        while(lastindex>0){
            index=0;
            while(index<lastindex){
                if(stocks[lastindex]-stocks[index]<maxloss){
                    break;
                }
            if(stocks[lastindex]-stocks[index]>maxloss && when[lastindex]<when[index]){
                maxloss=stocks[lastindex]-stocks[index];
                break;
            }
            index++;
            }
            lastindex--;
        }
        
        if(maxloss>0){
            System.out.println("-"+maxloss);
        }
        else{
            System.out.println("0");
        }
        
    }
}
