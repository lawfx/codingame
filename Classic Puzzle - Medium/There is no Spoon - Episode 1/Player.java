import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        
        in.nextLine();
        String[][] nodes = new String[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            String[] parts = line.split("");
            for(int j=0;j<width;j++){
                nodes[i][j]=parts[j];
            }
        }
        
        for(int i=0;i<height;i++){
           for(int j=0;j<width;j++){
                if(nodes[i][j].equals("0")){
                    System.out.print(j+" "+i);
                    System.out.print(" ");
                    int cnt=1;
                    while(j+cnt<width){
                        if(nodes[i][j+cnt].equals(".")){
                            cnt++;
                        }
                        else{
                            int temp=j+cnt;
                            System.out.print(temp+" "+i);
                            break;
                        }
                    }
                    if(j+cnt==width){
                        int temp=-1;
                        System.out.print(temp+" "+temp);
                    }
                    System.out.print(" ");
                    cnt=1;
                    while(i+cnt<height){
                        if(nodes[i+cnt][j].equals(".")){
                            cnt++;
                        }
                        else{
                            int temp=i+cnt;
                            System.out.print(j+" "+temp);
                            break;
                        }
                    }
                    if(i+cnt==height){
                        int temp=-1;
                        System.out.print(temp+" "+temp);
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("0 0 1 0 0 1");
    }
}
