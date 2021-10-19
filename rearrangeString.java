/*Simi, Strings and Queue (100 Marks)
Simi was learning about strings and Queue. She was writing random strings on paper but got stuck on one. 
She got fascinated by the string and thought of challenging you for the same. 
She will provide you with the strings and you have to print the output in the similar format as the given example. 
Carefully look at the example to understand the format of writing string. She has also asked you to use Queue for the same.*/

import java.util.*;
public class Main
{
    char[] arr;
    int topQueue, beginning;
    public Main(int size) {
        this.arr = new char[size];
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
    public void enQueue(char val) {
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
    public char deQueue() {
        char res = '\0';
        if(isEmpty()) System.out.println("Queue is Empty");
        else {
            res = arr[beginning];
            beginning++;
            if(beginning > topQueue) beginning = topQueue = -1;
        }
        return res;
    }
    public char peek() {
        
        if(isEmpty()) return '0';
        else {
        return arr[beginning];
        }
        
    }
    
        
        

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        String newStr = "";
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            String str = sc.next();
            Main mn = new Main(str.length());
            int half = str.length()/2;
            int upto = str.length()-half;
            for(int j=0; j<half; j++) {
                mn.enQueue(str.charAt(str.length()-j-1));
            }
            for(int k=0; k<upto; k++) {
                char ch = str.charAt(k);
                //System.out.println(ch);
                newStr+=ch;
                //System.out.println(newStr);
                if(!mn.isEmpty()) {
                    ch = mn.deQueue();
                    newStr+=ch;
                    
                }
            }
            System.out.println(newStr);
            newStr = "";
        }
        //System.out.println(newStr);
		
	}
}


