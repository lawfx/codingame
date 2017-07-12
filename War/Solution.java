import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        ArrayList<Integer> one = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            String temp = cardp1.substring(0,1);
            if(temp.equals("J")){
                one.add(13);
            }
            else if(temp.equals("Q")){
                one.add(14);
            }
            else if(temp.equals("K")){
                one.add(15);
            }
            else if(temp.equals("A")){
                one.add(16);
            }
            else if(temp.equals("1")){
                one.add(10);
            }
            else{
                one.add(Integer.parseInt(temp));
            }
            
        }
        int m = in.nextInt(); // the number of cards for player 2
        ArrayList<Integer> two = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            String temp = cardp2.substring(0,1);
            if(temp.equals("J")){
                two.add(13);
            }
            else if(temp.equals("Q")){
                two.add(14);
            }
            else if(temp.equals("K")){
                two.add(15);
            }
            else if(temp.equals("A")){
                two.add(16);
            }
            else if(temp.equals("1")){
                two.add(10);
            }
            else{
                two.add(Integer.parseInt(temp));
            }
        }
        
        int turns=0;
        boolean fight=true; //true fight - false war
        int winner=0; //1 one,2 two, 3 equal
        int warturns=4; //every warturn adds 3 to get next first start card
        while(winner==0){
            if(fight){  //fight
                warturns=4;
                if(one.get(0)>two.get(0)){
                    one.add(one.get(0));
                    one.add(two.get(0));
                    one.remove(0);
                    two.remove(0);
                    turns++;
                }
                else if(one.get(0)<two.get(0)){
                    two.add(one.get(0));
                    two.add(two.get(0));
                    two.remove(0);
                    one.remove(0);
                    turns++;
                }
                else{
                    fight=false;
                }
                if(one.isEmpty()){
                    winner=2;
                }
                else if(two.isEmpty()){
                    winner=1;
                }
            }
            else{   //war
            	if(one.size()<warturns || two.size()<warturns){
            		winner=3;
            	}
            	else{
	            	if(one.get(warturns)>two.get(warturns)){
	            		for(int i=0;i<=warturns;i++){
	            			one.add(one.get(0));
	            			one.remove(0);
	            		}
	            		for(int i=0;i<=warturns;i++){
	            			one.add(two.get(0));
	            			two.remove(0);
	            		}
	                    turns++;
	                    fight=true;
	                }
	            	else if(two.get(warturns)>one.get(warturns)){
	            		for(int i=0;i<=warturns;i++){
	            			two.add(one.get(0));
	            			one.remove(0);
	            		}
	            		for(int i=0;i<=warturns;i++){
	            			two.add(two.get(0));
	            			two.remove(0);
	            		}
	                    turns++;
	                    fight=true;
	                }
	            	else{
	                    warturns+=4;
	                }
	                if(one.isEmpty()){
	                    winner=2;
	                }
	                else if(two.isEmpty()){
	                    winner=1;
	                }
            	}
            }
        }
        
        if(winner==3){
            System.out.println("PAT");
        }
        else{
            System.out.println(winner+" "+turns);
        }
    }
    
}
