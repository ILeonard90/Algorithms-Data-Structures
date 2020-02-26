//given a set of instructions to get from a home location to a destination location, reverse the directions using a stack
import java.util.*;
public class Lab7{
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */      
		Scanner scan = new Scanner(System.in);
        int limit = 100;
        int count = 0;
        Stack directions = new Stack(limit);
        String opposite = "";
        String s = "";
        
        while(scan.hasNext()){
            s = scan.nextLine();
            if(s.equals("Arrived")==false ){
                if(s.equals("Go Back")){
                  directions.pop();
                }else{
                    opposite = reverseDirection(s);
                    directions.push(opposite);
                    count++;
                }                 
            }
            else{
                break;
            }        
        }
		
        for(int i = 0; i<count; i++){
            s=directions.peek();           
            System.out.println(s);
            directions.pop();
                               
        }
    }
    public static String reverseDirection(String direction){
        if(direction.equals("Go North")){
            direction = "Go South";
        }else if(direction.equals("Go South")){
            direction = "Go North";
        }else if(direction.equals("Go West")){
            direction = "Go East";
        }else if(direction.equals("Go East")){
            direction = "Go West";
        }/*else if(direction.equals("Go Back")){
            direction = "Go Back";
        } */
        return direction;
    }
  
    
}         
class Stack{

     private int maxSize; // size of stack array
     private String[] stackArray;
     private int top; // top of stack
    public Stack(int s) { // constructor

         maxSize = s; // set array size
         stackArray = new String[maxSize]; // create array
         top = -1; // no items yet
    } 
    public void push(String j) { // put item on top of stack

        top++;
         stackArray[top] = j; // increment top, insert item
    }
    public String pop() { // take item from top of stack

        return stackArray[top--]; //access item, decrement top
    }
    public String peek() { // peek at top of stack

        return stackArray[top];
    } 
    public boolean isEmpty() { // true if stack is empty

     return (top == -1);
    }
    public boolean isFull() { // true if stack is full

     return (top == maxSize-1);
    }
    public void makeEmpty() { // empty stack

    top=-1;

    }
}