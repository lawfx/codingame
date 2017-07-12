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
        while(cnt<first.length*7){
            if(final1[cnt].equals("0")){
                System.out.print("00 0");
                cnt++;
                while(final1[cnt].equals("0")){
                    System.out.print("0");
                    cnt++;
                }
                System.out.print(" ");
            }
            else{
                System.out.print("0 0");
                cnt++;
                while(final1[cnt].equals("1")){
                    System.out.print("0");
                    cnt++;
                }
                System.out.print(" ");
            }
        }
    }
}
