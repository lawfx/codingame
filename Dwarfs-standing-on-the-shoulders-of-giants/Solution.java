import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		
		ArrayList<Node> influences = new ArrayList<Node>();
		
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        for(int n=0;n<N;n++){
        	int from = in.nextInt();
        	int to = in.nextInt();
        	
        	Node fromNode = null;
        	Node toNode = null;
        	for(int i=0;i<influences.size();i++){
        		if(fromNode == null){
        			fromNode = FindNode(influences.get(i), from);
        		}
        		if(toNode == null){
        			toNode = FindNode(influences.get(i), to);
        		}
        		if(fromNode != null && toNode != null){
        			break;
        		}
        	}
        	if(fromNode == null && toNode == null){
        		Node childNode = new Node(to, null);
        		Node parentNode = new Node(from, childNode);
        		influences.add(parentNode);
        	}
        	else if(fromNode != null && toNode == null){
        		Node childNode = new Node(to, null);
        		fromNode.AddChild(childNode);
        	}
        	else if(fromNode == null && toNode != null){
        		Node parentNode = new Node(from, toNode);
        		for(int i=0;i<influences.size();i++){
        			if(influences.get(i).person == to){
        				influences.remove(i);
            			influences.add(parentNode);
            			break;
        			}
        		}
        	}
        	else{
        		fromNode.AddChild(toNode);
        	}
        }
        int maxDepth = 0;
        for(int i=0;i<influences.size();i++){
        	int depth = CountDepth(influences.get(i));
        	if(depth > maxDepth){
        		maxDepth = depth;
        	}
        }
        System.out.println(maxDepth);
	}
	
	static int CountDepth(Node currNode){
		
		if(currNode.children.size() == 0){
			return 1;
		}
		
		int maxBranchDepth = 0;
		for(int i=0;i<currNode.children.size();i++){
			int branchDepth = 1 + CountDepth(currNode.children.get(i));
			if(branchDepth > maxBranchDepth){
				maxBranchDepth = branchDepth;
			}
		}
		return maxBranchDepth;
	}
	
	static Node FindNode(Node currNode, int searchee){
		 
		if(currNode.person == searchee){
			return currNode;
		}
		else if(currNode.children.size() == 0){
			return null;
		}
		Node found = null;
		for(int i=0;i<currNode.children.size();i++){
			found = FindNode(currNode.children.get(i), searchee);
			if(found != null){
				break;
			}
		}
		return found;
	}
	
}

class Node{
	
	int person;
	ArrayList<Node> children = new ArrayList<Node>();
	
	public Node(int from, Node to){
		this.person = from;
		if(to != null){
			this.children.add(to);
		}
	}
	
	public void AddChild(Node child){
		this.children.add(child);
	}
	
}
