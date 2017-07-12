import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        T = T.substring(0).toLowerCase();
        String[] Tparts = T.split("");
        String[][] ascii= new String[H][27*L]; 
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            String[] temp = ROW.split("");
            for(int j=0;j<27*L;j++){
                ascii[i][j]=temp[j];
            }
        }
        for(int i=0;i<H;i++){
        for(int j=0;j<Tparts.length;j++){
            for(int k=0;k<L;k++){
                if(Tparts[j].equals("a")){
                    System.out.print(ascii[i][k+0]);
                }
                else if(Tparts[j].equals("b")){
                    System.out.print(ascii[i][k+L]);
                }
                else if(Tparts[j].equals("c")){
                    System.out.print(ascii[i][k+L*2]);
                }
                else if(Tparts[j].equals("d")){
                    System.out.print(ascii[i][k+L*3]);
                }
                else if(Tparts[j].equals("e")){
                    System.out.print(ascii[i][k+L*4]);
                }
                else if(Tparts[j].equals("f")){
                    System.out.print(ascii[i][k+L*5]);
                }
                else if(Tparts[j].equals("g")){
                    System.out.print(ascii[i][k+L*6]);
                }
                else if(Tparts[j].equals("h")){
                    System.out.print(ascii[i][k+L*7]);
                }
                else if(Tparts[j].equals("i")){
                    System.out.print(ascii[i][k+L*8]);
                }
                else if(Tparts[j].equals("j")){
                    System.out.print(ascii[i][k+L*9]);
                }
                else if(Tparts[j].equals("k")){
                    System.out.print(ascii[i][k+L*10]);
                }
                else if(Tparts[j].equals("l")){
                    System.out.print(ascii[i][k+L*11]);
                }
                else if(Tparts[j].equals("m")){
                    System.out.print(ascii[i][k+L*12]);
                }
                else if(Tparts[j].equals("n")){
                    System.out.print(ascii[i][k+L*13]);
                }
                else if(Tparts[j].equals("o")){
                    System.out.print(ascii[i][k+L*14]);
                }
                else if(Tparts[j].equals("p")){
                    System.out.print(ascii[i][k+L*15]);
                }
                else if(Tparts[j].equals("q")){
                    System.out.print(ascii[i][k+L*16]);
                }
                else if(Tparts[j].equals("r")){
                    System.out.print(ascii[i][k+L*17]);
                }
                else if(Tparts[j].equals("s")){
                    System.out.print(ascii[i][k+L*18]);
                }
                else if(Tparts[j].equals("t")){
                    System.out.print(ascii[i][k+L*19]);
                }
                else if(Tparts[j].equals("u")){
                    System.out.print(ascii[i][k+L*20]);
                }
                else if(Tparts[j].equals("v")){
                    System.out.print(ascii[i][k+L*21]);
                }
                else if(Tparts[j].equals("w")){
                    System.out.print(ascii[i][k+L*22]);
                }
                else if(Tparts[j].equals("x")){
                    System.out.print(ascii[i][k+L*23]);
                }
                else if(Tparts[j].equals("y")){
                    System.out.print(ascii[i][k+L*24]);
                }
                else if(Tparts[j].equals("z")){
                    System.out.print(ascii[i][k+L*25]);
                }
                else{
                    System.out.print(ascii[i][k+L*26]);
                }
            }
        }
        System.out.println();
        }
    }
}
