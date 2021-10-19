/*A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.

Your first task is to implement a queue. 
Then process  queries, where each query can be of three following types:

1 x:  Enqueue element  into the end of the queue.
2  :  Dequeue the element at the front of the queue.
3  :  Print the element at the front of the queue. */

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
        if(isEmpty()) System.out.println("Queue is Empty");
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
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
		Main mn = new Main(n);
		for(int i=0; i<n; i++) {
		    int ch = sc.nextInt();
		    if(ch == 1) {
		        int val = sc.nextInt();
		        mn.enQueue(val);
		    }
		    else if(ch == 2) {
		        mn.deQueue();
		    }
		    else if(ch == 3) {
		        System.out.println(mn.peek());
		    }
		    else System.out.println("-1");
		}
		
		
	}
}
