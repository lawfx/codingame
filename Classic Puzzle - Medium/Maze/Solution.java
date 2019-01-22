import java.util.*;

public class Solution {
	
	private ArrayList<int[]> array;
 
    public void sort(ArrayList<int[]> inputArr, int from, int upTo, boolean sortFirst) {
         
        if (inputArr == null || inputArr.size() == 0) {
            return;
        }
        this.array = inputArr;
        quickSort(from, upTo, sortFirst);
    }
 
    private void quickSort(int lowerIndex, int higherIndex, boolean sortFirst) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2)[1];
        if(sortFirst){
        	pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2)[0];
        }
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
        	int toCheck = array.get(i)[1];
        	if(sortFirst){
        		toCheck = array.get(i)[0];
        	}
            while (toCheck < pivot) {
                i++;
                toCheck = array.get(i)[1];
            	if(sortFirst){
            		toCheck = array.get(i)[0];
            	}
            }
            toCheck = array.get(j)[1];
            if(sortFirst){
            	toCheck = array.get(j)[0];
            }
            while (toCheck > pivot) {
                j--;
                toCheck = array.get(j)[1];
                if(sortFirst){
                	toCheck = array.get(j)[0];
                }
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j, sortFirst);
        if (i < higherIndex)
            quickSort(i, higherIndex, sortFirst);
    }
 
    private void exchangeNumbers(int i, int j) {
    	
    	int[] temp = new int[2];
        temp[0] = array.get(i)[0];
        temp[1] = array.get(i)[1];
        array.get(i)[0] = array.get(j)[0];
        array.get(i)[1] = array.get(j)[1];
        array.get(j)[0] = temp[0];
        array.get(j)[1] = temp[1];
    }
	
	static int[][] visited;
	static ArrayList<int[]> exits = new ArrayList<int[]>();

	public static void main(String args[]) {
		
        Scanner in = new Scanner(System.in);
        Solution sorter = new Solution();
        int W = in.nextInt();
        int H = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        visited = new int[H][W];
        
        Node[][] nodeMap = new Node[H][W];
        for (int i = 0; i < H; i++) {
            String R = in.nextLine();
            String[] parts = R.split("");
            for(int j=0;j<parts.length;j++){
            	boolean iswall = false;
            	if(parts[j].equals("#")){
            		iswall = true;
            	}
            	Node newNode = new Node(iswall, i, j, null);
            	nodeMap[i][j] = newNode;
            }
        }
        
        in.close();
        
        for(int i=0;i<H;i++){
        	for(int j=0;j<W-1;j++){
        		nodeMap[i][j].AddConnection(nodeMap[i][j+1]);
        		nodeMap[i][j+1].AddConnection(nodeMap[i][j]);
        	}
        }
        
        for(int i=0;i<H-1;i++){
        	for(int j=0;j<W;j++){
        		nodeMap[i][j].AddConnection(nodeMap[i+1][j]);
        		nodeMap[i+1][j].AddConnection(nodeMap[i][j]);
        	}
        }
        
        FindPossibleExits(nodeMap[Y][X], H - 1, W -1);
        
        sorter.sort(exits, 0, exits.size() - 1, false);
        
        if(exits.size() > 1){
        	int value = exits.get(0)[1];
        	int index = 0;
        	for(int i=1;i<exits.size();i++){
        		if(exits.get(i)[1] != value){
        			sorter.sort(exits, index, i-1, true);
        			value = exits.get(i)[1];
        			index = i;
        		}
        	}
        	sorter.sort(exits, index, exits.size() - 1, true);
        }
        
        System.out.println(exits.size());
        for(int i = 0; i<exits.size();i++){
        	System.out.println(exits.get(i)[1] +" "+ exits.get(i)[0]);
        }
	}
	
	static void FindPossibleExits(Node currNode, int maxVer, int maxHor){
	
		if(currNode.isWall){
			return;
		}
		
		if(visited[currNode.X][currNode.Y] == 1){
			return;
		}
	    visited[currNode.X][currNode.Y] = 1;
		
		if(currNode.X == maxVer || currNode.X == 0 || currNode.Y == maxHor || currNode.Y == 0){
			boolean already = false;
			for(int i = 0;i<exits.size();i++){
				if(exits.get(i)[0] == currNode.X && exits.get(i)[1] == currNode.Y){
					already = true;
					break;
				}
			}
			if(!already){
				exits.add(new int[]{currNode.X, currNode.Y});
			}
			return;
		}
		
		for(int i=0;i<currNode.connections.size();i++){
			FindPossibleExits(currNode.connections.get(i), maxVer, maxHor);
		}
		return;
		
	}
	
}

class Node{
	
	boolean isWall;
	int X;
	int Y;
	ArrayList<Node> connections = new ArrayList<Node>();
	
	public Node(boolean isWall, int x, int y, Node to){
		this.isWall = isWall;
		this.X = x;
		this.Y = y;
		if(to != null){
			this.connections.add(to);
		}
	}
	
	public void AddConnection(Node conn){
		this.connections.add(conn);
	}
	
}
