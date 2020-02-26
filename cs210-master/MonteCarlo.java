import java.lang.Math;
//monte carlo - what is the probability of the presendential canddiates coming in a specific order

public class MonteCarlo{

	public static void main(String args[]){
	
	double MDH = (50.00/51.00);
	double SG = (1.00/21.00);
	double LR = (1.00/34.00);
	double PC = (1.00/41.00);
	double GD = (1.00/101.00);
	double JF = (1.00/101.00);
	
	double total = MDH+SG+LR+PC+GD+JF; //This is the total of all the 6 odds/probabilities
	
	
	double probFinal = 0.00;
	boolean check = false;
	double countFinal = 0.00;
		
	
	//Array that holds the count of how many times each person won 
	double [] countArray = new double[6];
	
	//Array that holds the probability of the person winning adfter the Monte Carlo trials
	double [] probability = new double[6];
	
	//Initialise all values as zero
	for(int j =0; j<6; j++){
		countArray[j] = 0.00;
		probability[j]=0.00;
	}
	
	//Limit is how many MC trials we are doing
	int limit = 100000;
	
	//Monte Carlo trials 
	for(int i =1; i<=limit; i++){
	
		double num = Math.random()*total; //Makes a random num between 0 and total
		
		if(num<=MDH){
			countArray[0]++; // This array value holds how many times MDH won
		}
		else if(num>MDH && num <=MDH+SG){
				countArray[1]++;
		}else if(num>MDH+SG && num <= MDH+SG+LR){
				countArray[2]++;
		}else if(num> MDH+SG+LR && num <= MDH+SG+LR+PC){
				countArray[3]++;
		}else if(num>MDH+SG+LR+PC && num<=MDH+SG+LR+PC+GD){
				countArray[4]++; //  both GD and JF as they should come in around the same
		}else if(num>MDH+SG+LR+PC+GD && num<=total){
				countArray[5]++;
		} 
		
		//checks if a value is greater than the values after it
		for(int j = 0; j<5; j++){ //  countArray[4] and [5] both represent GD and JF as they should come in around the same
			for(int k = j+1; k<5; k++){
				if(countArray[j]>countArray[k]){
					check = true;
				} else{
					check =false;
					break; //if this is false at any point, we stop checking
				}
			}
				if(check==false){
					break;
				}
		}	
		if(check == true){
			countFinal++; //CountFinal is the number of times the candidates run in the correct order
		}
	
	}
	
	//The probability of the candidates come in the order specified is:
	probFinal = countFinal/limit;
	System.out.println(probFinal);	
	
	}
}