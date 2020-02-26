//subset sum problem - find the smallest difference between the sums of two random groups from a set of numbers

import java.lang.Math;
import java.util.Arrays;

public class SubsetSum{
	
	public static void main(String args[]){
		
		int size=64;
		//long [] numArray = new long [size];
		long [] numArray = {7270536038336708566L, 8019217342518227357L, 3040884611156577620L, 4971410678527411098L, 183064013267932758L, 8056584603037925167L, 1899884129638764508L, 5128941762697709445L, 5047244487910064394L, 3305601720113745382L, 5776953008539814370L, 34988082947722169L, 7434345681532331612L, 5407786886759427803L, 688068291500036320L, 2068510150417278708L, 1868790318480929054L, 3425404376196216488L, 1131190712360422749L, 102967645096808272L, 1445942735952374406L, 8456737838228485082L, 7623544032966572081L, 3942629391233399085L, 75109850685511728L, 223515536869223609L, 764673323466830185L, 2792331077502901882L, 8043871486090449356L, 8027891460874623856L, 9035205129603316628L, 5210176758109223792L, 6369027410439876015L, 719764136449271247L, 6275216998605832028L, 7518974182407464286L, 8228098362075889963L, 4364500170274364383L, 5160900320056121570L, 3574188741140445768L, 3799725687163235416L, 8971054323076859594L, 303947614746485290L, 4072768654844778108L, 422948319988286530L, 228169257627773589L, 4695919214544378987L, 5634695221137989240L, 2134479954298742138L, 7591363728605668117L, 227743280468209272L, 3815359581987719752L, 240831188333789404L, 1682051551566226L, 7028911732181187415L, 8534901095561461575L, 604981729275990578L, 4379371367686136078L, 2561184379973031673L, 3251231714574439892L, 8507596701451728093L, 1479176915196229414L, 4596908701725205546L, 7434222118200184219L};
		
		double diff = 0;
	
		double smallestDiff =100.0;
		long [] group1 = new long[size];
		long [] group2 = new long[size];
		group1 = setArray(group1, 0); //Fill all of group1 with zeroes
		group2 = setArray(group2, 0);
		int numArraySize = numArray.length;
	


		double total1 = 0;
		double total2 = 0;
		long limit1=0;
		long limit2=0;
		
		//Monte carlo simulation
		for(long i =1; i<=1000000; i++){
			//Set sizes of each group
			limit1 = (int)(Math.random()* size); //Number of elements in group1			
			limit2 = (int)(Math.random()* size);
			
			//Fill group1
			for(int j=0;j<limit1; j++){
				numArray= shuffleArray(numArray); //Shuffles the array
				numArraySize = numArray.length-1;
				group1[j]=numArray[numArraySize]; //Sets the current element of group1 as the last element in the shuffled array

				total1= total1 + group1[j];	 //Total of the current values in group 1
				Arrays.copyOfRange(numArray, 1, numArraySize); //Deletes the last element in the array, so it won't be used again
				numArraySize = numArraySize-1;	//Reduces this variable to reflect the array size after deleting
						
				
			}
			//Fill group2
			for(int j=0;j<limit2; j++){
				numArray= shuffleArray(numArray);
				numArraySize = numArray.length-1;
				group2[j]=numArray[numArraySize];
				total2= total2 + group2[j];			
				Arrays.copyOfRange(numArray, 1, numArraySize);

				numArraySize = numArraySize-1;
				
			}
			if(total1>total2){ //Find the difference which must be positive
				diff = total1-total2;
			}else{
				diff = total2-total1;
			}
			
			if(i==1){
				smallestDiff = diff; //Initially sets the smallest difference as the first diff, all others are compared to that
			} 
			if(diff<smallestDiff){
				smallestDiff = diff;//If the difference is smaller than the smallest difference found so far, set it as the smallest difference
			}	
		}
	
			
			
		System.out.println("The smallest difference is: " + smallestDiff);

		
		
	}
	public static long[] setArray(long[] array1, long value){
		for(int i = 0; i<array1.length;i++){
			array1[i]=value;
		}
		return array1;
	}
	//Method to shuffle an array
	public static long[] shuffleArray(long[] array){
		long temp = 0; 
		for (int i = array.length-1; i>0; i--){
			int randomIndex = (int)(Math.random()*i); //Set your random as an index as between 0 and the current array index, so previous values won't be used
			temp = array[i]; //Back up your current array value
			array[i] = array[randomIndex]; //Put the value of the random array index into your current array value
			array[randomIndex] = temp; //Swap the values of array[i] and random array value
			
		}
	return array;	
	}
	//Checks if a number is already included in an array
	public static boolean checkIsInArray(long num, long[] array1){
		for(int i = 0; i<array1.length; i++){ 
			if(num==array1[i]){
				return true;
			}
		}		
		return false;
	}
}

	
		