import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        int l=0;
        int r=0;
        int u=0;
        int d=0;
        String prev="";
        boolean flag=false;
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            
            if(!flag){prev=bombDir;}
            
            if(bombDir.equals("U")){
                if(!flag){
                    d=Y0;
                    u=0;
                    flag=true;
                }
                else{
                d=Y0;
                }
                Y0 = (d+u)/2;
            }
            else if(bombDir.equals("UR")){
                if(!flag){
                    d=Y0;
                    u=0;
                    l=X0;
                    r=W;
                    flag=true;
                }
                else{
                 d=Y0;
                 l=X0;
                }
                 Y0 = (d+u)/2;
                 X0 = (l+r)/2;
            }
            else if(bombDir.equals("UL")){
                if(!flag){
                    d=Y0;
                    u=0;
                    l=0;
                    r=X0;
                    flag=true;
                }
                else{
                 d=Y0;
                 r=X0;
                }
                 Y0 = (d+u)/2;
                 X0 = (l+r)/2;
            }
            else if(bombDir.equals("D")){
                if(!flag){
                    u=Y0;
                    d=H;
                    flag=true;
                }
                else{
                u=Y0;
                }
                Y0 = (d+u)/2;
            }
            else if(bombDir.equals("DR")){
                if(!flag){
                    u=Y0;
                    d=H;
                    l=X0;
                    r=W;
                    flag=true;
                }
                else{
                u=Y0;
                l=X0;
                }
                Y0 = (d+u)/2;
                X0 = (l+r)/2;
            }
            else if(bombDir.equals("DL")){
                if(!flag){
                    u=Y0;
                    d=H;
                    l=0;
                    r=X0;
                    flag=true;
                }
                else{
                u=Y0;
                r=X0;
                }
                Y0 = (d+u)/2;
                X0 = (l+r)/2;
            }
            else if(bombDir.equals("R")){
                if(!flag){
                    l=X0;
                    r=W;
                    flag=true;
                }
                else{
                l=X0;
                }
                X0 = (l+r)/2;
            }
            else if(bombDir.equals("L")){
                if(!flag){
                    l=0;
                    r=X0;
                    flag=true;
                }
                else{
                r=X0;
                }
                X0 = (l+r)/2;
            }
            
            System.out.println(X0+ " "+Y0);
            prev=bombDir;
         }
    }
}
