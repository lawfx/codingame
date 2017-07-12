import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            for(int j=0;j<W;j++){
            map[i][j] = in.nextInt(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        while (true) {
            int YI = in.nextInt();
            int XI = in.nextInt();
            String POS = in.next();
            
            if(POS.equals("LEFT")){
                if(map[XI][YI]==1 || map[XI][YI]==5 || 
                   map[XI][YI]==8 || map[XI][YI]==9 || 
                   map[XI][YI]==13){
                       int temp=XI+1;
                    System.out.println(YI +" "+ temp);
                }
                else if(map[XI][YI]==2 || map[XI][YI]==6){
                     int temp=YI+1;
                    System.out.println(temp +" "+ XI);
                }
            }
            else if(POS.equals("TOP")){
                if(map[XI][YI]==1 || map[XI][YI]==3 ||
                   map[XI][YI]==7 || map[XI][YI]==9){
                        int temp=XI+1;
                    System.out.println(YI +" "+ temp);
                }
                else if(map[XI][YI]==4 || map[XI][YI]==10){
                     int temp=YI-1;
                     System.out.println(temp +" "+ XI);
                }
                else if(map[XI][YI]==5 || map[XI][YI]==11){
                     int temp=YI+1;
                     System.out.println(temp +" "+ XI);
                }
            }
            else{
                if(map[XI][YI]==1 || map[XI][YI]==4 ||
                   map[XI][YI]==7 || map[XI][YI]==8 ||
                   map[XI][YI]==12){
                        int temp=XI+1;
                    System.out.println(YI +" "+ temp);
                }
                else if(map[XI][YI]==2 || map[XI][YI]==6){
                     int temp=YI-1;
                    System.out.println(temp +" "+ XI);
                }
            }
        }
    }
}
