import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();
        String[] conway = new String[L];
        conway[0] = Integer.toString(R);
        if(L>1){
            conway[1] = "1-"+conway[0];
        }
        int cnt = 1;
        while(cnt+1<L){
        	String[] parts = conway[cnt].split("-");
        	cnt++;
        	String currnum = parts[0];
        	int groupcnt = 1;
        	for(int i=1;i<parts.length;i++){
        		if(parts[i].equals(currnum)){
        			groupcnt++;
        		}
        		else{
        			if(conway[cnt]==null){
        				conway[cnt] = Integer.toString(groupcnt)+"-"+currnum;
        			}
        			else{
        				conway[cnt] = conway[cnt]+"-"+Integer.toString(groupcnt)+"-"+currnum;
        			}
        			groupcnt=1;
        			currnum=parts[i];
        		}
        	}
        	if(conway[cnt]==null){
				conway[cnt] = Integer.toString(groupcnt)+"-"+currnum;
			}
			else{
				conway[cnt] = conway[cnt]+"-"+Integer.toString(groupcnt)+"-"+currnum;
			}
        }
        
       String[] parts = conway[L-1].split("-");
       for(int i=0;i<parts.length;i++){
           if(i+1<parts.length){
    	    System.out.print(parts[i]+" ");
           }
           else{
               System.out.print(parts[i]);
           }
       }
    }
}
