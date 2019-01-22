import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        int[][] links= new int[L][2];
        for (int i = 0; i < L; i++) {
            links[i][0] = in.nextInt(); // N1 and N2 defines a link between these nodes
            links[i][1] = in.nextInt();
        }
        int[] gates = new int[E];
        for (int i = 0; i < E; i++) {
            gates[i] = in.nextInt(); // the index of a gateway node
        }

        int cnt=0;
        while (true) {
            int SI = in.nextInt();
            boolean flagnext=false;
            for(int i=0;i<L;i++){
                for(int j=0;j<E;j++){
                if((links[i][0]==SI && links[i][1]==gates[j]) || (links[i][1]==SI && links[i][0]==gates[j])){
                System.out.println(links[i][0]+" "+links[i][1]);
                flagnext=true;
                }
            }
            }
             if(!flagnext){
            for(int i=cnt;i<L;i++){
                boolean flag=false;
                for(int j=0;j<E;j++){
                    if(links[i][0]==gates[j] || links[i][1]==gates[j]){
                        System.out.println(links[i][0]+" "+links[i][1]);
                        cnt=i+1;
                        flag=true;
                        break;
                    }
                }
                if(flag){break;}
            }
            }
        }
    }
}
