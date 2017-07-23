import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        String[] first = MESSAGE.split("");
        String[] final1 = new String[first.length*7];
        int cnt=0;
        for(int i=0;i<first.length;i++){
            byte[] bytes = first[i].getBytes();
            StringBuilder binary = new StringBuilder();
            for (byte b : bytes)
            {
            	int val = b;
            	for (int j = 0; j < 8;j++)
            	{
            		binary.append((val & 128) == 0 ? 0 : 1);
            		val <<= 1;
            	}
            	binary.append(' ');
            }
            String test= binary.toString();
            String[] parts = test.split("");
            for(int k=0;k<7;k++){
            	final1[cnt+k]=parts[k+1];
            }
        cnt+=7;
        }
        cnt=0;
        boolean isOne = false;
        for(int i=0;i<final1.length;i++){
        	if(i==0){
        		if(final1[i].equals("1")){
        			System.out.print("0 0");
        			isOne = true;
        		}
        		else{
        			System.out.print("00 0");
        			isOne = false;
        		}
        	}
        	else{
        		if(final1[i].equals("1")){
        			if(isOne){
        				System.out.print("0");
        			}
        			else{
        				isOne = true;
        				System.out.print(" 0 0");
        			}
        		}
        		else{
        			if(isOne){
        				isOne = false;
        				System.out.print(" 00 0");
        			}
        			else{
        				System.out.print("0");
        			}
        		}
        	}
        }
    }
}
