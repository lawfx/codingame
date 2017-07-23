import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        String MESSAGE = in.nextLine();
        String[] parts = MESSAGE.split(" ");
        
        String res = "";
        
        boolean isOne = false;
        boolean switchTime = false;
        boolean isOK = true;
        if(parts[0].equals("0")){
        	isOne = true;
        	res += "1";
        }
        else if(parts[0].equals("00")){
        	isOne = false;
        	res += "0";
        }
        else{
        	isOK = false;
        	System.out.println("INVALID");
        }
        if(isOK){
	        for(int i=1;i<parts.length;i++){
	        	if(switchTime){
	        		if(parts[i].equals("00") && isOne){
	        			isOne = false;
	        			res += "0";
	        		}
	        		else if(parts[i].equals("0") && !isOne){
	        			isOne = true;
	        			res += "1";
	        		}
	        		else{
	        			System.out.println("INVALID");
	        			isOK = false;
	        			break;
	        		}
	        		switchTime = false;
	        	}
	        	else{
	        		for(int j = 0;j<parts[i].length()-1;j++){
	        			if(isOne){
	        				res += "1";
	        			}
	        			else{
	        				res += "0";
	        			}
	        		}
	        		switchTime = true;
	        	}
	        }
        }
        if(isOK){
        	if(res.length()% 7 != 0){
            	System.out.println("INVALID");
            }
        	else{
        		 for(int i=0;i<res.length();i+=7){
     	        	char temp = (char) Integer.parseInt(res.substring(i, i+7), 2);
     	        	System.out.print(new Character(temp).toString());
     	        }
        	}
        }
    }
}
