// take in a credit card number, and find out if it is a valid credit card
//number or not using luhn's algorithm

import java.util.*;

public class luhns {
    public static void main(String args[] ) throws Exception {
        int total = 0;
        int total1 =0;
        int total2  =0;
        int temp2 = 0;
        
       //Take in credit card number
        Scanner scan = new Scanner(System.in);
       
        String number = scan.nextLine();
        int numberSize = number.length();
        if(numberSize<4|| numberSize>30){
           
            number = scan.nextLine();
            numberSize = number.length();
        }
        
        //Split string
        String delimiter = "";
        String [] temp = number.split(delimiter);
 
        
        //Add check+ other digits
        for(int i = numberSize-1; i>= 0; i-=2){
            temp2 = Integer.parseInt(temp[i]);
            total1 = total1 + temp2;            
        }
        //Double every second digit from last and add them
        temp2 = 0;
        for(int j=numberSize-2; j>=0; j-=2){
            temp2 = Integer.parseInt(temp[j]);
            temp2 = temp2*2;
            if(temp2>9){
                temp2 = temp2-9;
            }
            total2 = total2 + temp2;
        }
        //Add both totals and check if it is equal to 0 mod 10
        total = total1+total2;
        if(total%10==0){
            System.out.println("VALID");
        } else{
            System.out.println("INVALID");
        }       
        
    }
}