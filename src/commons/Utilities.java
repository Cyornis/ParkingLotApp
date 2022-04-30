package commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.Scanner;

public class Utilities {
     public static String intractiveInput(int maxLimit)  {
    	 
//    	 BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    	 
    	 Scanner cin= new Scanner(System.in);
    	 String str;
    	 boolean valid=true;
    	 
    	 
    	 do {
    		 
    		 str=cin.next(); 
//    		 str =cin.readLine();
    		 
    		 if(str.length()>maxLimit) {
    			 System.out.println("INVALID INPUT");
   			 
    			 valid=false;
    		 }
    		 
    		 else {
    			 valid=true;
    		 }
    	   
    	 }while(str.isEmpty() || valid==false);
    	 
		return str;
    	 
    }
     
     public static int elapsedTime(Instant instant1,Instant instant2) {
    	 
    	 long diff = instant2.getEpochSecond()-instant1.getEpochSecond();
    	 int hours = (int)(diff/3600);
    	 return hours;
     }
    
     

}

















