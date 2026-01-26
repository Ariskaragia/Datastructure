/*p3220066 ARISTEIDHS KARAGIANNAKOS
 * p3220037 ELLY DANAZI
 */

import java.io.PrintStream;
import java.util.*;

public class StringDoubleEndedQueueLmpl<T> implements StringDoubleEndedQueue<T> {

public static int  count=0;

    private NodeList<T> head = null;
    private NodeList<T> tail = null;

    public StringDoubleEndedQueueLmpl() {
    }

    
    public boolean isEmpty() {
        return head == null;
    }

    
    public void addFirst(T data) {
        NodeList<T> n = new NodeList<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            head.previous = n;
            n.setNext(head);
            head = n;
            
        }
        count++;
    }


    
    public void addLast(T data) {
        NodeList<T> n = new NodeList<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.previous = tail;
            tail.setNext(n);
            tail = n;
        }
        count++;
    }

    public T removeFirst() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = head.getData();

        if (head == tail)
            head = tail = null;
        else{
            head = head.getNext();
            head.previous=null;
        }

        count--;

        return data;
    }


    public T  removeLast() throws   NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            tail=tail.previous;
            tail.next=null;
        }
        count--;

        return data;
    }



    public T getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = head.getData();

        return data;
    }
    


    public T getLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = tail.getData();

        return data;
    }


    public void printQueue(PrintStream stream) {
        if (isEmpty()) {
            System.out.println("List is empty :(");
        }

        NodeList current = head;
         PrintStream ret = new PrintStream(stream);

       
        ret.append("HEAD -> ");

        while (current != null) {
            ret.append(current.data.toString());

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");
    }

    public int size() {
        return count;
    }
}
