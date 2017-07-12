import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            if(lightY==initialTY && lightX>initialTX){
                initialTX++;
                  System.out.println("E");
            }
            else if(lightY>initialTY && lightX>initialTX){
                initialTX++;
                initialTY++;
                 System.out.println("SE");
            }
            else if(lightY>initialTY && lightX==initialTX){
                initialTY++;
                 System.out.println("S");
            }
            else if(lightY>initialTY && lightX<initialTX){
                initialTY++;
                initialTX--;
                 System.out.println("SW");
            }
            else if(lightY==initialTY && lightX<initialTX){
                initialTX--;
                 System.out.println("W");
            }
            else if(lightY<initialTY && lightX<initialTX){
                initialTY--;
                initialTX--;
                 System.out.println("NW");
            }
            else if(lightY<initialTY && lightX==initialTX){
                initialTY--;
                 System.out.println("N");
            }
            else if(lightY<initialTY && lightX>initialTX){
                initialTY--;
                initialTX++;
                 System.out.println("NE");
            }

        }
    }
}
