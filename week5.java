package solution;
import java.util.Stack;

class node<E> {
    E data;
    node next;
    node(E data) {
        this.data = data;
    }
}
class LL<E> {
    private node<E> head, tail;
    node<E> head() {
        return this.head;
    }
    boolean isEmpty(){
        return head == null;
    }
    void insertB(E data){
        node<E> newNode = new node(data);
        if (head == null){
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
    }
    void insertF(E data) {
        node<E> newNode = new node(data);
        if (tail == null){
            tail = head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
}
public class week5<E> {
    
    public static boolean isPallindrome(LL<Character> list) throws IllegalArgumentException {
        if (list.isEmpty()) throw new IllegalArgumentException("list is empty and/or null argument reference");

        //lists with only one node.
        node tmp = list.head();
        if (tmp.next == null) return true;
        
        node runner = list.head();
        return isPallindrome(runner, tmp, new Stack<>()); 
    }
    private static boolean isPallindrome(node runner, node tmp, Stack<Character> stack) {   
       
       // move a runner node at twice the speed to push the first half of tmp onto the stack.
       // then pop that stack and compare to remaining tmp nodes.
       // O(n/2 + n/2) = O(n) run-time.
       // O(2n + n) = O(n) space complexity. (2 additional node lists, 1 stack)
        while (runner.next != null) {
            runner = runner.next;
            if (runner.next != null) {
                runner = runner.next;
                stack.push((char)tmp.data);
            }
            tmp = tmp.next;
        }
        // if odd, skip the middle element.
        if (runner != null) tmp = tmp.next;
        
        // compare stack contents to tmp.
        while (!stack.isEmpty()) {
            if(!tmp.data.equals(stack.pop())) 
                return false;
            tmp = tmp.next;
        }
        return true;
    }
}
