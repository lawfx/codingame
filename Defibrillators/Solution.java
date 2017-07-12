import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next().replace(",", ".");
        String LAT = in.next().replace(",", ".");
        double LONhuman = Double.parseDouble(LON);
        double LAThuman = Double.parseDouble(LAT);
        int N = in.nextInt();
        in.nextLine();
        double min=15000000;
        String which="";
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] parts = DEFIB.split(";");
            double londef = Double.parseDouble(parts[4].replace(",", "."));
            double latdef = Double.parseDouble(parts[5].replace(",", "."));
            double x=(londef-LONhuman)*Math.cos((latdef+LAThuman)/2);
            double y =latdef - LAThuman;
            double d = Math.sqrt(x*x+y*y)*6371;
            if(d<min){min=d; which=parts[1];}
        }
        System.out.println(which);
        in.close();
    }
}
