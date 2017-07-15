import java.util.*;

public class Solution {
	
	static int[] visited = new int[200000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node map = null;
		
		int relations  = sc.nextInt();
		
		int[][] links = new int[relations][2];
		
		Node[] nodes = new Node[200000];
		
		int min = Integer.MAX_VALUE;
		for(int r=0;r<relations;r++){
			int first = sc.nextInt();
			int second = sc.nextInt();
			if(first < min){
				min = first;
			}
			if(second < min){
				min = second;
			}
			if(nodes[first] == null){
				Node newConn = new Node(first, null);
				nodes[first] = newConn;
			}
			if(nodes[second] == null){
				Node newConn = new Node(second, null);
				nodes[second] = newConn;
			}
				links[r][0] = first;
				links[r][1] = second;
		}
		
		sc.close();
		
		for(int i=0;i<relations;i++){
			nodes[links[i][0]].AddConnection(nodes[links[i][1]]);
			nodes[links[i][1]].AddConnection(nodes[links[i][0]]);
		}
		 map = nodes[min]; 

		visited = new int[200000];
		Node emptyNode = ScanForEmpty(map);
		visited = new int[200000];
		int maxD = CalculateMaxDepth(emptyNode);
		System.out.println(maxD/2);
	}
	
	static int CalculateMaxDepth(Node currNode){
		
		if(visited[currNode.value] == 1){
			return -1;
		}
	    visited[currNode.value] = 1;
	    
	    int maxBranchDepth = 1;
	    for(int i=0;i<currNode.connections.size();i++){
	    	int branchDepth = 1 + CalculateMaxDepth(currNode.connections.get(i));
	    	if(branchDepth > maxBranchDepth){
	    		maxBranchDepth = branchDepth;
	    	}
	    }
	    return maxBranchDepth;
	}
	
	static Node ScanForEmpty(Node currNode){
		
		if(visited[currNode.value] == 1){
			return null;
		}
	    visited[currNode.value] = 1;
	    
	    if(currNode.connections.size() == 1){
			return currNode;
		}
	    
	    Node found = null;
	    for(int i=0;i<currNode.connections.size();i++){
	    	found = ScanForEmpty(currNode.connections.get(i));
	    	if(found != null){
	    		break;
	    	}
	    }
	    return found;
	}
	
}

class Node{
	
	int value;
	ArrayList<Node> connections = new ArrayList<Node>();
	
	public Node(int from, Node to){
		this.value = from;
		if(to != null){
			this.connections.add(to);
		}
	}
	
	public void AddConnection(Node conn){
		this.connections.add(conn);
	}
	
}
