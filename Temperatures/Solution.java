import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		if(N > 0){
			int min = 10000;
			boolean isPos = true;
			for(int i=0;i<N;i++){
				int num = in.nextInt();
				if(Math.abs(num) <= min){
					if(Math.abs(num) < min && num < 0){
						isPos = false;
					}
					else if(num > 0){
						isPos = true;
					}
					min = Math.abs(num);
				}
			}
			in.close();
			if(isPos){
				System.out.println(min);
			}
			else{
				System.out.println(-min);
			}
		}
		else{
			System.out.println(0);
		}
	}
}
