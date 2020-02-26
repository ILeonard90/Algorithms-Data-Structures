//scans in a list of numbers, sorts them and finds the median
import java.io.*;
import java.util.Scanner;
public class median {
public static void main(String args[] ) throws Exception {
    /* Scans in array  */
    Scanner scan = new Scanner(System.in);
    int inputNum = scan.nextInt();    
    int numbers[] = new int[inputNum];
    double median = 0;
    int middle = (inputNum/2);
    for(int i = 0; i<inputNum; i++){
        numbers[i]=scan.nextInt();
    }
    //Sort array
    numbers = selectionSort(numbers);
    for(int i = 0; i<inputNum; i++){
        System.out.print(numbers[i]+ " ");
    }
    
    //finds the median
    if(inputNum % 2==0){
		
        median = (numbers[middle-1]+numbers[middle])/2;
    }else{
        median = numbers[middle];
    }
	System.out.println("");
   System.out.println(median);
    
}
    public static int[] selectionSort(int array[]){
        int min;
        for(int outer = 0; outer<array.length; outer++){
             min = outer;
            
            for(int i = outer+1; i<array.length; i++){
                if(array[i]<array[min]){
                    min = i;
                }
            }
            swap(array,outer,min);
             
        }
        return array;        
    }
    
    public static int[] swap(int array[],int a, int b){
       
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
		return array;
    }
}