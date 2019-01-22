import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

   public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int C = in.nextInt();
        in.nextLine();
        String[][] map = new String[L][C];  //o xartis
        int[][] walked = new int[L][C];    //pou perpatise
        int startposx = 0;
        int startposy = 0;
        int[][] teles = new int[2][2]; //gia tous dio teleporters
        boolean flagtele = false; //ama mpike o protos teleporter
        for (int i = 0; i < L; i++) {
            String row = in.nextLine();
            String[] parts = row.split("");
            for(int j = 0;j<C;j++){
            	if(parts[j].equals("@")){  //pairnei arxiki thesi
            		startposx=i;
            		startposy=j;
            	}
            	else if(parts[j].equals("T")){
            		if(!flagtele){
            			teles[0][0]=i;
            			teles[0][1]=j;
            			flagtele = true;
            		}
            		else{
            			teles[1][0]=i;
            			teles[1][1]=j;
            		}
            	}
            	map[i][j] = parts[j];  //ftiaxnei pinaka
            }
        }
        
        boolean loop = false;  //gia ama perasei deuteri fora apo arxi
        String direction = "S"; //default direction South
        boolean breaker = false; //false gia normal -- true gia breaker mode
        boolean reverse = false; //false gia normal -- true gia reverse
        int whereami_x = startposx;  //current location bender x
        int whereami_y = startposy; //current location bender y
        String finalpath = "start";
        boolean flagbroken = false; //ama exei spasei toixos
        while(!(map[whereami_x][whereami_y].equals("$"))){ //ama patise sto telos
        	walked[whereami_x][whereami_y]++;
        	if(walked[whereami_x][whereami_y]==10){
        		loop=true;
        		break;
        	}
        	if(map[whereami_x][whereami_y].equals("B")){
        		breaker = !breaker;
        	}
        	else if(map[whereami_x][whereami_y].equals("S")){
        		direction = "S";
        	}
        	else if(map[whereami_x][whereami_y].equals("E")){
        		direction = "E";
        	}
        	else if(map[whereami_x][whereami_y].equals("N")){
        		direction = "N";
        	}
        	else if(map[whereami_x][whereami_y].equals("W")){
        		direction = "W";
        	}
        	else if(map[whereami_x][whereami_y].equals("T")){
        		if(teles[0][0] == whereami_x && teles[0][1] == whereami_y){
        			whereami_x = teles[1][0];
        			whereami_y = teles[1][1];
        		}
        		else{
        			whereami_x = teles[0][0];
        			whereami_y = teles[0][1];
        		}
        	}
        	else if(map[whereami_x][whereami_y].equals("I")){
        		reverse = !reverse;
        	}
        	
        	if(breaker){ //an spaei ta panta
        		if(map[whereami_x][whereami_y].equals("X")){
        			map[whereami_x][whereami_y] = " ";
        			flagbroken=true;
        		}
        		if(direction.equals("S")){ //an pigainei notia
        			if(!(map[whereami_x+1][whereami_y].equals("#"))){ //an den einai akraios toixos
        				whereami_x++;
        				finalpath+="-SOUTH";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x][whereami_y+1].equals("#"))){
        						whereami_y++; //paei east
        						direction = "E";
        						finalpath+="-EAST";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y-1].equals("#"))){
                						whereami_y--; //paei west
                						direction = "W";
                						finalpath+="-WEST";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x][whereami_y-1].equals("#"))){
        						whereami_y--; //paei west
        						direction = "W";
        						finalpath+="-WEST";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y+1].equals("#"))){
                						whereami_y++; //paei east
                						direction = "E";
                						finalpath+="-EAST";
                					}
        						}
        					}
        				}
        			}
        		}
        		else if(direction.equals("E")){
        			if(!(map[whereami_x][whereami_y+1].equals("#"))){ //an den einai akraios toixos
        				whereami_y++;
        				finalpath+="-EAST";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x+1][whereami_y].equals("#"))){
        						whereami_x++; //paei south
        						direction = "S";
        						finalpath+="-SOUTH";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y-1].equals("#"))){
                						whereami_y--; //paei west
                						direction = "W";
                						finalpath+="-WEST";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x][whereami_y-1].equals("#"))){
        						whereami_y--; //paei west
        						direction = "W";
        						finalpath+="-WEST";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x+1][whereami_y+1].equals("#"))){
                						whereami_x++; //paei south
                						direction = "S";
                						finalpath+="-SOUTH";
                					}
        						}
        					}
        				}
        			}
        		}
        		else if(direction.equals("N")){
        			if(!(map[whereami_x-1][whereami_y].equals("#"))){ //an den einai akraios toixos
        				whereami_x--;
        				finalpath+="-NORTH";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x+1][whereami_y].equals("#"))){
        						whereami_x++; //paei south
        						direction = "S";
        						finalpath+="-SOUTH";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y-1].equals("#"))){
                						whereami_y--; //paei west
                						direction = "W";
                						finalpath+="-WEST";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x][whereami_y-1].equals("#"))){
        						whereami_y--; //paei west
        						direction = "W";
        						finalpath+="-WEST";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x+1][whereami_y+1].equals("#"))){
                						whereami_x++; //paei south
                						direction = "S";
                						finalpath+="-SOUTH";
                					}
        						}
        					}
        				}
        			}
        		}
        		else{  //an pigainei west
        			if(!(map[whereami_x][whereami_y-1].equals("#"))){ //an den einai akraios toixos
        				whereami_y--;
        				finalpath+="-WEST";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x+1][whereami_y].equals("#"))){
        						whereami_x++; //paei south
        						direction = "S";
        						finalpath+="-SOUTH";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x-1][whereami_y].equals("#"))){
                						whereami_x--; //paei north
                						direction = "N";
                						finalpath+="-NORTH";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x-1][whereami_y].equals("#"))){
        						whereami_x--; //paei north
        						direction = "N";
        						finalpath+="-NORTH";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x+1][whereami_y+1].equals("#"))){
                						whereami_x++; //paei south
                						direction = "S";
                						finalpath+="-SOUTH";
                					}
        						}
        					}
        				}
        			}
        		}
        	}
        	else{ //den einai se breaker
        		if(direction.equals("S")){ //an pigainei notia
        			if(!(map[whereami_x+1][whereami_y].equals("#") || map[whereami_x+1][whereami_y].equals("X"))){ //an den einai akraios toixos
        				whereami_x++;
        				finalpath+="-SOUTH";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x][whereami_y+1].equals("#") || map[whereami_x][whereami_y+1].equals("X"))){
        						whereami_y++; //paei east
        						direction = "E";
        						finalpath+="-EAST";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#") || map[whereami_x-1][whereami_y].equals("X"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y-1].equals("#") || map[whereami_x][whereami_y-1].equals("X"))){
                						whereami_y--; //paei west
                						direction = "W";
                						finalpath+="-WEST";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x][whereami_y-1].equals("#") || map[whereami_x][whereami_y-1].equals("X"))){
        						whereami_y--; //paei west
        						direction = "W";
        						finalpath+="-WEST";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#") || map[whereami_x-1][whereami_y].equals("X"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y+1].equals("#") || map[whereami_x][whereami_y+1].equals("X"))){
                						whereami_y++; //paei east
                						direction = "E";
                						finalpath+="-EAST";
                					}
        						}
        					}
        				}
        			}
        		}
        		else if(direction.equals("E")){
        			if(!(map[whereami_x][whereami_y+1].equals("#") || map[whereami_x][whereami_y+1].equals("X"))){ //an den einai akraios toixos
        				whereami_y++;
        				finalpath+="-EAST";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x+1][whereami_y].equals("#") || map[whereami_x+1][whereami_y].equals("X"))){
        						whereami_x++; //paei south
        						direction = "S";
        						finalpath+="-SOUTH";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#") || map[whereami_x-1][whereami_y].equals("X"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y-1].equals("#") || map[whereami_x][whereami_y-1].equals("X"))){
                						whereami_y--; //paei west
                						direction = "W";
                						finalpath+="-WEST";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x][whereami_y-1].equals("#") || map[whereami_x][whereami_y-1].equals("X"))){
        						whereami_y--; //paei west
        						direction = "W";
        						finalpath+="-WEST";
        					}
        					else{
        						if(!(map[whereami_x-1][whereami_y].equals("#") || map[whereami_x-1][whereami_y].equals("X"))){
            						whereami_x--; //paei north
            						direction = "N";
            						finalpath+="-NORTH";
            					}
        						else{
        							if(!(map[whereami_x+1][whereami_y+1].equals("#") || map[whereami_x+1][whereami_y+1].equals("X"))){
                						whereami_x++; //paei south
                						direction = "S";
                						finalpath+="-SOUTH";
                					}
        						}
        					}
        				}
        			}
        		}
        		else if(direction.equals("N")){
        			if(!(map[whereami_x-1][whereami_y].equals("#") || map[whereami_x-1][whereami_y].equals("X"))){ //an den einai akraios toixos
        				whereami_x--;
        				finalpath+="-NORTH";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x+1][whereami_y].equals("#") || map[whereami_x+1][whereami_y].equals("X"))){
        						whereami_x++; //paei south
        						direction = "S";
        						finalpath+="-SOUTH";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#") || map[whereami_x][whereami_y+1].equals("X"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x][whereami_y-1].equals("#") || map[whereami_x][whereami_y-1].equals("X"))){
                						whereami_y--; //paei west
                						direction = "W";
                						finalpath+="-WEST";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x][whereami_y-1].equals("#") || map[whereami_x][whereami_y-1].equals("X"))){
        						whereami_y--; //paei west
        						direction = "W";
        						finalpath+="-WEST";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#") || map[whereami_x][whereami_y+1].equals("X"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x+1][whereami_y+1].equals("#") || map[whereami_x+1][whereami_y+1].equals("X"))){
                						whereami_x++; //paei south
                						direction = "S";
                						finalpath+="-SOUTH";
                					}
        						}
        					}
        				}
        			}
        		}
        		else{  //an pigainei west
        			if(!(map[whereami_x][whereami_y-1].equals("#") || map[whereami_x][whereami_y-1].equals("X"))){ //an den einai akraios toixos
        				whereami_y--;
        				finalpath+="-WEST";
        			}
        			else{ //an einai toixos
        				if(!reverse){ //ama den einai stin antistrofi fasi
        					if(!(map[whereami_x+1][whereami_y].equals("#") || map[whereami_x+1][whereami_y].equals("X"))){
        						whereami_x++; //paei south
        						direction = "S";
        						finalpath+="-SOUTH";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#") || map[whereami_x][whereami_y+1].equals("X"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x-1][whereami_y].equals("#") || map[whereami_x-1][whereami_y].equals("X"))){
                						whereami_x--; //paei north
                						direction = "N";
                						finalpath+="-NORTH";
                					}
        						}
        					}
        				}
        				else{
        					if(!(map[whereami_x-1][whereami_y].equals("#") || map[whereami_x-1][whereami_y].equals("X"))){
        						whereami_x--; //paei north
        						direction = "N";
        						finalpath+="-NORTH";
        					}
        					else{
        						if(!(map[whereami_x][whereami_y+1].equals("#") || map[whereami_x][whereami_y+1].equals("X"))){
            						whereami_y++; //paei east
            						direction = "E";
            						finalpath+="-EAST";
            					}
        						else{
        							if(!(map[whereami_x+1][whereami_y+1].equals("#") || map[whereami_x+1][whereami_y+1].equals("X"))){
                						whereami_x++; //paei south
                						direction = "S";
                						finalpath+="-SOUTH";
                					}
        						}
        					}
        				}
        			}
        		}
        	}
        }
        if(loop){
        	System.out.println("LOOP");
        }
        else{
        	String[] parts = finalpath.split("-");
        	for(int i=1;i<parts.length;i++){
        		System.out.println(parts[i]);
        	}
        }

    }
}
