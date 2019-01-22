import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int biggest = 0;
            int which = 0;
            int nowbest = 0;
            for (int i = 0; i < 8; i++) {
                which=in.nextInt();
                if(which>nowbest){
                biggest = i;
                nowbest=which;
            }}

            System.out.println(biggest); 
            }
    }
}
