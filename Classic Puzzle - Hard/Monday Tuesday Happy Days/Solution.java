import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        
        int isLeap = in.nextInt();
        
        int day = StringToIntDay(in.next());
        int startMon = StringToIntMonth(in.next());
        int startDate = in.nextInt();
        
        int endMon = StringToIntMonth(in.next());
        int endDate = in.nextInt();
        
        if(endMon > startMon || (endMon == startMon && endDate >= startDate)){
        	for(int m=startMon;m<=endMon;m++){
        		int startD = 1;
        		int daysToPass = countDaysToPass(m, isLeap);
        		if(m == startMon){
        			startD = startDate + 1;
        		}
        		if(m == endMon){
        			daysToPass = endDate;
        		}
        		
				for(int d = startD; d < daysToPass + 1; d++){
					day++;
					if(day == 8){
						day = 1;
					}
				}
			}
        }
        else if(endMon == startMon && endDate < startDate){
        	
        	for(int d = startDate; d > endDate; d--){
        		day--;
        		if(day == 0){
        			day = 7;
        		}
        	}
        }
        else if(endMon < startMon){
        	for(int m=startMon;m>=endMon;m--){
        		int endD = 0;
        		int daysToPass = countDaysToPass(m, isLeap);
        		if(m == endMon){
        			endD = endDate;
        		}
        		if(m == startMon){
        			daysToPass = startDate;
        		}
        		
				for(int d = daysToPass; d > endD; d--){
	        		day--;
	        		if(day == 0){
	        			day = 7;
	        		}
	        	}
        	}
        }
        System.out.println(IntToStringDay(day));
        
    }
    
    static String IntToStringDay(int day){
    	
    	if(day == 1){
    		return "Monday";
    	}
    	else if(day == 2){
    		return "Tuesday";
    	}
    	else if(day == 3){
    		return "Wednesday";
    	}
    	else if(day == 4){
    		return "Thursday";
    	}
    	else if(day == 5){
    		return "Friday";
    	}
    	else if(day == 6){
    		return "Saturday";
    	}
    	else{
    		return "Sunday";
    	}
    }
    
    static int countDaysToPass(int m, int isLeap){
    	
    	int daysToPass = 31;
    	if(m == 4 || m == 6 || m == 9 || m == 11){
			daysToPass = 30;
		}
		else if(m == 2){
			daysToPass = 28;
			if(isLeap == 1){
				daysToPass = 29;
			}
		}
    	return daysToPass;
    }
    
    static int StringToIntDay(String day){
    	
    	if(day.equals("Monday")){
    		return 1;
    	}
    	else if(day.equals("Tuesday")){
    		return 2;
    	}
    	else if(day.equals("Wednesday")){
    		return 3;
    	}
    	else if(day.equals("Thursday")){
    		return 4;
    	}
    	else if(day.equals("Friday")){
    		return 5;
    	}
    	else if(day.equals("Saturday")){
    		return 6;
    	}
    	else{
    		return 7;
    	}
    }
    
    static int StringToIntMonth(String month){
    	
    	if(month.equals("Jan")){
    		return 1;
    	}
    	else if(month.equals("Feb")){
    		return 2;
    	}
    	else if(month.equals("Mar")){
    		return 3;
    	}
    	else if(month.equals("Apr")){
    		return 4;
    	}
    	else if(month.equals("May")){
    		return 5;
    	}
    	else if(month.equals("Jun")){
    		return 6;
    	}
    	else if(month.equals("Jul")){
    		return 7;
    	}
    	else if(month.equals("Aug")){
    		return 8;
    	}
    	else if(month.equals("Sep")){
    		return 9;
    	}
    	else if(month.equals("Oct")){
    		return 10;
    	}
    	else if(month.equals("Nov")){
    		return 11;
    	}
    	else{
    		return 12;
    	}
    }
}
