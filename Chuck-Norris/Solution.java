import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        char[] chars = MESSAGE.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            String temp = Integer.toBinaryString(chars[i]);
            if(temp.length() < 7){
            	String temp1 = "";
            	for(int j=temp.length();j<7;j++){
            		temp1 += "0";
            	}
            	temp = temp1 + temp;
            }
            res += temp;
        }
        boolean isOne = false;
        for(int i=0;i<res.length();i++){
        	if(i==0){
        		if(res.substring(i, i+1).equals("1")){
        			System.out.print("0 0");
        			isOne = true;
        		}
        		else{
        			System.out.print("00 0");
        			isOne = false;
        		}
        	}
        	else{
        		if(res.substring(i, i+1).equals("1")){
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
