package commons;

import java.util.Scanner;

public class Utilities {
     public static String intractiveInput(int maxLimit) {
    	 
    	 Scanner cin= new Scanner(System.in);
    	 String str;
    	 boolean valid=true;
    	 
    	 
    	 do {
    		 
    		 str=cin.next(); 
    		 
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
    
}
