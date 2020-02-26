//Find the longest Collatz sequence which descends through your student number - can change one digit

import java.util.Scanner;
public class Collatz{
	
	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Please type your student number: ");
		long number = scan.nextInt();
		long number2 = 0;
		

		for(int j = -5; j<5; j++){
			//changes the last digit of the student number, and checks the collatz lenght of each
				
			number2 = number + j;
			collatzMethod(number2); 
							
		}		
		 
	}
	public static long collatzCount(long num){
		//gets count of the collata sequence
		long count = 0;
		
		while(num>1){			
			
			if(num%2==0){
				num=num/2;
			} else{
				num=(num*3)+1;
			}
			
			count++;
			
		}
		
		return count;
	}
	public static boolean studentNumberCheck(long num, long number){
		//checks if student number is in sequence
		long count = 0;		
		boolean check = false;
		
		while(num>1){			
			
			if(num%2==0){
				num=num/2;
			} else{
				num=(num*3)+1;
			}
			if(num == number){ //this means sequence passes through student number
				check = true;
				return check;
			}		
			
		}
		
		return check;
	}

	public static void collatzMethod(long number){
		boolean checkNum = false;
		long i = 2;
		long temp = 0;
		long biggest = 0;
		long multiplier = 1;
		long limit = 90000000000000L;
		
		
		while((number*i)<limit){
			//first check if student number is in sequence
			checkNum = studentNumberCheck(number*i, number);
			if(checkNum==true){
				temp = collatzCount(number*i);
				
				if(biggest<temp){
					//keeping track of the longest collatz sequence using the number 
					biggest = temp;
					multiplier = i;
				}
			}	
			i++;
		}
		long bigNum = number*multiplier;
		System.out.print(bigNum + " collatz sequence has length: ");
		System.out.print(biggest);
		System.out.println("");
		
		checkNum = studentNumberCheck(bigNum, number);
		System.out.println("The student number " + number + " is in the sequence: " + checkNum);
		System.out.println("");
		
	}
}