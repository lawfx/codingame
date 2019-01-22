import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
		Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        String[][] numbers = new String[20][H*L];
        for (int i = 0; i < H; i++) {
            String numeral = in.next();
            String[] parts = numeral.split("");
            for(int k=0;k<20;k++){
	            for(int j=0;j<H;j++){
	            	numbers[k][j+i*H] = parts[k*H+j];
	            }
            }
        }
        int S1 = in.nextInt();
        long firstnum = sol.getNum(L, H, S1/L, numbers, in);
        int S2 = in.nextInt();
        long secondnum = sol.getNum(L, H, S2/L, numbers, in);
        String oper = in.next();

        long finalres = 0L;
        if(oper.equals("+")){
        	finalres = firstnum+secondnum;
        }
        else if(oper.equals("-")){
        	finalres = firstnum-secondnum;
        }
        else if(oper.equals("*")){
        	finalres = firstnum*secondnum;
        }
        else if(oper.equals("/")){
        	finalres = firstnum/secondnum;
        }
        
        int powindex = 0;
        long currentpow = (long) Math.pow(20, powindex);
        String finalfuckingnumber = "start";
        int lastpow = 0;
        while(finalres>19){
        	powindex=0;
        	currentpow = (long) Math.pow(20, powindex);
	        while(currentpow<=finalres){
	        	powindex++;
	        	currentpow = (long) Math.pow(20, powindex);
	        }
	        powindex -= 1;
	        int baseindex=0;
	        while(Math.pow(20, powindex)*baseindex<=finalres){
	        	baseindex++;
	        }
	        baseindex-=1;
	        finalres-=(baseindex)*Math.pow(20, powindex);
	        if(lastpow-powindex>=2){
	        	for(int i = lastpow-powindex;i>=2;i--){
	        		finalfuckingnumber += "-"+Integer.toString(0);
	        	}
	        }
	        finalfuckingnumber += "-"+Integer.toString(baseindex);
	        lastpow=powindex;
        }
        finalfuckingnumber+="-"+Long.toString(finalres);
        
        String[] paparia = finalfuckingnumber.split("-");
        for(int i=1;i<paparia.length;i++){
        	for(int j=0;j<L;j++){
        		for(int k=0;k<L;k++){
            		System.out.print(numbers[Integer.parseInt(paparia[i])][j*H+k]);
            	}
        		System.out.println();
        	}
        }
        
    }
	
	public long getNum(int L, int H, int iters, String[][] numbers, Scanner in){
		String firstnum = "";
        for (int i = iters; i > 0; i--) {
        	String[] whichnum = new String[L*H];
        	String num1Line = "";
        	for(int j=0;j<L;j++){
        		num1Line += in.next();
        	}
        	String[] parts = num1Line.split("");
        	System.arraycopy( parts, 0, whichnum, 0, parts.length);
        	for(int k=0;k<20;k++){
        		boolean flag=true;
	            for(int j=0;j<H*L;j++){
	            	if(!(whichnum[j].equals(numbers[k][j]))){
	            		flag=false;
	            		break;
	            	}
	            }
	            if(flag){
	            	double thereisres = k*Math.pow(20, i-1);
	            	int thereisthis = (int) thereisres;
	            	if(!(firstnum.equals(""))){
	            		firstnum = Integer.toString(Integer.parseInt(firstnum)+thereisthis);
	            	}
	            	else{
	            		firstnum = Integer.toString(thereisthis);
	            	}
	            	break;
	            }
	        }
        }
        return Long.parseLong(firstnum);
	}
}
