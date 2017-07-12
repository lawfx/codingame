import java.util.*;

public class Solution {
	
	static ArrayList<Node> tels = new ArrayList<Node>();
	
	public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    
    for (int i = 0; i < N; i++) {
    	String tel = in.next();
    	String[] parts = tel.split("");
    	
    	Node nodeStartedInputting = null;
    	Node headTemp = null;
    	
    	nodeStartedInputting = new Node(1, Integer.parseInt(parts[0]));
    	headTemp = nodeStartedInputting;
		for(int t=1;t<parts.length;t++){
			Node newChild = new Node(t+1, Integer.parseInt(parts[t]));
			nodeStartedInputting.AddChild(newChild);
			nodeStartedInputting = newChild;
		}
    	
    	if(tels.size() > 0){
    		boolean foundIn = false;
    		for(int t=0; t<tels.size();t++){
    			if(tels.get(t).value == headTemp.value){
    				CompareTels(tels.get(t), headTemp);
    				foundIn = true;
    			}
    		}
    		if(!foundIn){
    			tels.add(headTemp);
    		}
    	}
    	else{
    		tels.add(headTemp);
    	}
    }
    
    in.close();
    
   int[] sums = new int[tels.size()];
   int totalsum = 0;
   for(int i=0;i<tels.size();i++){
	   sums[i] = 1;
	   sums[i] = CalculateSum(tels.get(i));
	   totalsum += sums[i];
   }
   
   System.out.println(totalsum);
}
	
	static int CalculateSum(Node currNode){
		
		int maxD = 1;
		if(currNode.nextNodes.size() == 0){
			return maxD;
		}
		else if(currNode.nextNodes.size() == 1){
			maxD += CalculateSum(currNode.nextNodes.get(0));
			return maxD;
		}
		else{
			for(int i=0;i< currNode.nextNodes.size();i++){
				maxD += CalculateSum(currNode.nextNodes.get(i));
			}
			return maxD;
		}
	}
	
	static void CompareTels(Node saved, Node importing){
		if(saved.value == importing.value){
			if(saved.nextNodes.size() > 0 && importing.nextNodes.size() == 0){
				return;
			}
			else if(saved.nextNodes.size() == 0 && importing.nextNodes.size() > 0){
				saved.AddChild(importing.nextNodes.get(0));
				return;
			}
			else if(saved.nextNodes.size() > 0 && importing.nextNodes.size() > 0){
				boolean gotIn = false;
				for(int i = 0;i <saved.nextNodes.size();i++){
					if(saved.nextNodes.get(i).value == importing.nextNodes.get(0).value){
						CompareTels(saved.nextNodes.get(i), importing.nextNodes.get(0));
						gotIn = true;
						break;
					}
				}
				if(!gotIn){
					saved.AddChild(importing.nextNodes.get(0));
				}
			}
			else{
				return;
			}
		}
	}
}

class Node{
	
	int depth;
	int value;
	ArrayList<Node> nextNodes;
	
	public Node(int depth, int num){
		this.depth = depth;
		this.value = num;
		this.nextNodes = new ArrayList<Node>();
	}
	
	public void AddChild(Node child){
		this.nextNodes.add(child);
	}
}
