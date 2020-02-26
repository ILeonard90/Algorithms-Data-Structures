// a recursive method that finds the probability that in a class of n people, some pair of
//them will have the same birthday.
import java.util.Scanner;

public class birthdayProblem {
    public static void main(String args[] ){
        Scanner myscanner = new Scanner(System.in);
        int n = myscanner.nextInt();
        System.out.println(String.format( "%.3f", (1-birthday(n))));
    }
    
    public static double birthday(int n){
        double value = 1.0;
        int x =0;
        if(n<=1){
            return 1.0;
        }else{        
            x = n-1;
            value = (365.0-x)/365.0;
        }

        return (value*birthday(x));
    }
}
