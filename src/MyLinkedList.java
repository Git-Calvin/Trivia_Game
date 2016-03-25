/**
 * MyLinkedList.java
 *
 *
 * Created by Calvin Wong on 9/25/14.
 *
 *
 * My own version of a LinkedList
 *
 */
public class MyLinkedList {

    private Node head; // holds node head
    private int listCount; // list count


    public MyLinkedList() {

        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data) { // add

        Node Temp = new Node(data);
        Node Current = head;

        while (Current.getNext() != null) {
            Current = Current.getNext();
        }

        Current.setNext(Temp);
        listCount++;
    }

    public void add(Object data, int index) { // add with index

        Node Temp = new Node(data);
        Node Current = head;

        for (int i = 1; i < index && Current.getNext() != null; i++) {
            Current = Current.getNext();
        }

        Temp.setNext(Current.getNext());

        Current.setNext(Temp);
        listCount++;
    }

    public Object get(int index) { // get

        if (index <= 0)
            return null;

        Node Current = head.getNext();

        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;

            Current = Current.getNext();
        }
        return Current.getData();
    }

    public boolean remove(int index) { // remove node

        if (index < 1 || index > size())
            return false;

        Node Current = head;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;

            Current = Current.getNext();
        }

        Current.setNext(Current.getNext().getNext());
        listCount--;
        return true;
    }

    public int size() {  // return size
        return listCount;
    }

    public String toString() { // toString

        Node Current = head.getNext();
        String output = "";

        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }

    private class Node { // node class
        Node next;
        Object data;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
} // end of class
