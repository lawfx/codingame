import java.util.*;

public class Solution {

	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int Q = in.nextInt();
        
        String[][] associations = new String[N][2];
        
        for(int i=0;i<N;i++){
        	String ext = in.next();
        	String mime = in.next();
        	ext = ext.toLowerCase();
        	associations[i][0] = ext;
        	associations[i][1] = mime;
        }
        for(int i=0;i<Q;i++){
        	String file = in.next();
        	file = file.toLowerCase();
        	String[] parts = file.split("\\.");
        	String[] loneParts = file.split("");
        	boolean gotIn = false;
        	for(int j=0;j<N;j++){
        		if(!loneParts[loneParts.length-1].equals(".") && parts.length > 1 && parts[parts.length-1].equals(associations[j][0])){
        			System.out.println(associations[j][1]);
        			gotIn = true;
        			break;
        		}
        	}
        	if(!gotIn){
        		System.out.println("UNKNOWN");
        	}
        }
	}
}
