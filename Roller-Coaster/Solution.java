import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int C = in.nextInt();
        int N = in.nextInt();
        
        ArrayList<int[]> groups = new ArrayList<int[]>();
        for (int i = 0; i < N; i++) {
            groups.add(new int[]{in.nextInt(), i});
        }

        long cntCoins = 0L;
        ArrayList<long[]> firsts = new ArrayList<long[]>();
        int firstExists = 0;
        boolean firstFind = false;
        int currIndex = 0;
        for(int i=0;i<C;i++){
            int cntPpl = 0;
            int cntRows = 0;
            if(!firstFind){
	            for(int j=0;j<firsts.size();j++){
	            	if(groups.get(0)[0] == firsts.get(j)[0] && groups.get(0)[1] == firsts.get(j)[1]){
	            		firstExists  = j;
	            		currIndex = j;
	            		firstFind = true;
	            		break;
	            	}
	            }
	            if(!firstFind){
	            	firsts.add(new long[]{groups.get(0)[0],groups.get(0)[1], 0});
		            while(groups.get(0)[0] + cntPpl <= L && cntRows < N){
		                cntPpl += groups.get(0)[0];
		                int[] tempGroup1 = groups.get(0);
		                groups.remove(0);
		                groups.add(tempGroup1);
		                cntRows++;
		            }
		            cntCoins += cntPpl;
		            firsts.get(firsts.size() - 1)[2] = cntPpl;
	            }
	            else{
	            	cntCoins += firsts.get(firstExists)[2];
	            	if(currIndex < firsts.size() - 1){
	            		currIndex++;
	            	}
	            	else{
	            		currIndex = 0;
	            	}
	            }
            }
            else{
            	cntCoins += firsts.get(currIndex)[2];
            	if(currIndex < firsts.size() - 1){
            		currIndex++;
            	}
            	else{
            		currIndex = firstExists;
            	}
            }
        }
        System.out.println(cntCoins);
    }
}
