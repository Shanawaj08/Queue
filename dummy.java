import java.util.*;
public class Main
{
    int[] arr;
    int topQueue, beginning;
    public Main(int size) {
        this.arr = new int[size];
        this.topQueue = -1;
        this.beginning = -1;
    }
    public boolean isFull() {
        if(topQueue == arr.length-1) return true;
        else return false;
    }
    public boolean isEmpty() {
        if(beginning == -1 || beginning == arr.length) return true;
        else return false;
    }
    public void enQueue(int val) {
       if(isFull()) System.out.println("Queue is Full");
       else if(isEmpty()) {
           beginning = 0;
           topQueue++;
           arr[topQueue] = val;
       }
       else {
           topQueue++;
           arr[topQueue] = val;
       }
    }
    public int deQueue() {
        int res = 0;
        if(isEmpty()) return -1;
        else {
            res = arr[beginning];
            beginning++;
            if(beginning > topQueue) beginning = topQueue = -1;
        }
        return res;
    }
    public int peek() {
        
        if(isEmpty()) return -1;
        else {
        return arr[beginning];
        }
        
    }
	public static void main(String[] args) {
	    Main mn = new Main(1);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
		    int input = sc.nextInt();
		    int c = 1;
		    while(c > 0 && n<=100) {
		        if(c%input == 0) mn.enQueue(c);
		        String temp = Integer.toString(mn.peek());
		        if(!mn.isEmpty() && temp.matches("^[05]+$")) {
		            System.out.println(Integer.valueOf(temp));
		            mn.deQueue();
		            break;
		        }
		        else {
		            mn.deQueue();
		            c++;
		            continue;
		        }
		    }
		}
		
	}
}
