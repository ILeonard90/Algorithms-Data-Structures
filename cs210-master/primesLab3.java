//read in a number N and output the Nth prime number. For example,
//if N is 3, then output 5, because 5 is the third prime number.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class primesLab3 {
    public static void main(String args[] ) {
       //reads in number num between 2 and 1000
      
	    Scanner scan = new Scanner(System.in);
		int  num = 0;
        while(num<=2 || num >= 1000){
          
           num = scan.nextInt();
       }   
        
        int smallPrime = 0;
        int largePrime = 0;
        int result = 0;
        boolean[] primeCheck = new boolean[num+1];
        boolean check = false;
        
        //find prime before number
        primeCheck = primeSieve(num);
        for(int i = 2; i<= num; i++){
            if(primeCheck[i]==true){
                smallPrime = i;
            }
        }
        //find prime after number
        int j=num+1;
        while(check==false){
            primeCheck=primeSieve(j);
            if(primeCheck[j]==true){
                largePrime=j;
                check=true;
            }
            j++;    
        }
        //find distance between primes
        result = largePrime - smallPrime;
        System.out.println(result);
    }
    public static boolean[] primeSieve(int x){
        boolean[] sieve = new boolean[x+1];
        sieve[0]= false;
        sieve[1] = false;
        //set all value from 2 onwards as true
        for(int i = 2; i<=x; i++){
            sieve[i]=true;
        }
        //check if values are prime:
        for(int j=2; j<=x; j++){
            if(sieve[j]==true){
                for(int k = j+j; k<=x; k=k+j){
                    if(k%j==0){
                        sieve[k]=false;
                    }
                }
            }
        }
        return sieve; 
    }
    
}