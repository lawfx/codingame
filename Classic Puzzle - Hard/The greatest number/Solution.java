import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        ArrayList<String> charsTemp = new ArrayList<String>();
        boolean hasMinus = false;
        boolean hasDot = false;
        for(int i=0;i<N;i++){
        	String temp = in.next();
        	if(temp.equals("-")){
        		hasMinus = true;
        	}
        	else if(temp.equals(".")){
        		hasDot = true;
        	}
        	else{
        		charsTemp.add(temp);
        	}
        }
        String[] chars = new String[charsTemp.size()];
        for(int i=0;i<chars.length;i++){
        	chars[i] = charsTemp.get(i);
        }
        Arrays.sort(chars);
        String res = "";
        if(hasMinus){
        	res += "-";
        	for(int i=0;i<chars.length;i++){
        		if(hasDot && i == 1){
        			res += ".";
        		}
        		res += chars[i];
        	}
        }
        else{
        	for(int i=chars.length-1;i>=0;i--){
        		if(hasDot && i == 0){
        			res += ".";
        		}
        		res += chars[i];
        	}
        }
        if(hasDot){
        	while(res.substring(res.length() - 1, res.length()).equals("0")){
        		res = res.substring(0, res.length() - 1);
        	}
        	if(res.substring(res.length() - 1, res.length()).equals(".")){
        		res = res.substring(0, res.length() - 1);
        	}
        	if(hasMinus && res.length() == 2 && res.substring(1,2).equals("0")){
        		res = "0";
        	}
        }
        System.out.println(res);
    }
}
