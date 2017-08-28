package micp;
import java.util.Objects;

class node<E> {
    E data;
    node next;
    node(E data) {
        this.data = data;
    }
}
class LinkedList<E> {
    private node<E> head, tail;
    void insertB(E data){
        node<E> newNode = new node(data);
        if (Objects.equals(head, null)){
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
    }
    void insertF(E data) {
        node<E> newNode = new node(data);
        if (Objects.equals(tail, null)){
            tail = head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    void print() {
        for (node<E> curNode = head;!Objects.equals(curNode,null); curNode = curNode.next)
            System.out.print(curNode.data + " ");
        System.out.println();
    }
    boolean isEmpty(){
        return Objects.equals(head, null);
    }
    int count() {
        node<E> tmp = head;
        int count = 0;
        while (!Objects.equals(tmp,null)) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    // removes head node and returns its data.
    E pop(){
        if (Objects.equals(head, null)){
            return null;
        }
        else {
            E headData = head.data;
            head = head.next;
   
            // if we just removed the only node in the list
            if (Objects.equals(head, null))
                tail = null;
 
            return headData;
        }
    }
}
public class week5 {
    private static int evenTestSize = 30;
    private static int oddTestSize = 31;
    
    public static void main(String[] args) {
        LinkedList<Integer> evenTrueTest = generateList(evenTestSize, true);
        LinkedList<Integer> evenFalseTest = generateList(evenTestSize, false);
        LinkedList<Integer> oddTrueTest = generateList(oddTestSize, true);
        LinkedList<Integer> oddFalseTest = generateList(oddTestSize, false);
    }
    public static LinkedList<Integer> generateList(int targetSize, boolean isPallindrome){
        LinkedList<Integer> LL = new LinkedList();
        // true cases
        if (isPallindrome) {
            // True, even
            if (targetSize %2 == 0) {
                for (int i = 0; i < targetSize/2; i++)
                    LL.insertB(i);
                for (int i = 0; i < targetSize/2; i++)
                    LL.insertF(i); 
            }
            // True, odd
            else {
                for (int i = 0; i < targetSize/2; i++)
                    LL.insertB(i);
                LL.insertB(targetSize/2);
                for (int i = 0; i < targetSize/2; i++)
                    LL.insertF(i);
            }
            else {
               if (targetSize %2 == 0) {
                    for (int i = 0; i < targetSize/2; i++)
                    LL.insertB(i);
               
                for (int i = 0; i < targetSize/2; i++)
                    LL.insertF(i); 
            }
                    }
        } 
        
        System.out.println("isPallindrome: " + isPallindrome 
                         + " Planned size: " + targetSize 
                         + " Actual size: " + LL.count());
        LL.print();
        
        int pt1, pt2;
        
    }
}
