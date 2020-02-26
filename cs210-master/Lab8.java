//insert a certain amount of commands in the a queue, 'INSERT hi' inserts the string hi. REMOVE removes the head of the queue
//then print out the middle of the queue
import java.util.Scanner;

public class Lab8 {
    public static void main(String args[] ) throws Exception {

        Scanner scan = new Scanner(System.in);
        Queue queue1 = new Queue(20);
        int count = 0;
        int middle = 0;
		System.out.println("Please enter a queue size");
        int size = scan.nextInt();
        String [] command;
        String middleOfQueue = "";
        System.out.println("Please enter a a list of commands. e.g. 'INSERT this' 'INSERT is'. To remove, type REMOVE");
        while(count<size){
            if(scan.hasNext()){
                command = scan.nextLine().split(" ");
				if(command[0].equals("INSERT")){
                queue1.insert(command[1]);
                count++;
				}
				else if(command[0].equals("REMOVE")){
					queue1.remove();
					count--;
				}
			}
           
        }
       
        if(queue1.isEmpty()){
            System.out.println("empty");
        }
        
        else if(size%2!=0){
            middle = (size/2)+1;
            middleOfQueue = queue1.peekAtIndex(middle-1);
        } else {
            middle = (size/2);
            middleOfQueue = queue1.peekAtIndex(middle-1);

        }
        System.out.println(middleOfQueue);
    }
}

class Queue{
    
    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public Queue(int s){
        maxSize = s;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        
    }
    
    public boolean insert(String item){ 
    //Insert at back
        if(isFull()){
            return false;
        }
        if(rear == maxSize-1){
            rear=-1;
        }
        rear++;
        queArray[rear] = item;
        nItems++;
        return true;

    }
      
    public String remove(){
    //Remove at front   
        if(isEmpty()){
            return null;
        }
        String temp = queArray[front];
        front++;
        //Wraparound if front is at back
        if(front==maxSize){
            front=0;
        }
        nItems--;
        return temp;
    } 

    public boolean isEmpty(){ 
        return (nItems==0);
    }
        
    public boolean isFull(){
        return (nItems==maxSize);
    }
        
    public int size(){ 
        return nItems;
    } 
    public String peekAtIndex(int index){
        return queArray[front+index];
    }
}

