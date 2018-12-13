package firststage.linkedlist;

public class MyDoublyList {
    private Node head;
    private Node last;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyDoublyList() {
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return findNode(index).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(null, val, head);
        Node f = head;
        head = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(last, val, null);
        Node l = last;
        last = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index >= 0 && index < size) {
            Node ith = findNode(index);
            Node newNode = new Node(ith.prev, val, ith);
            if(ith.prev!=null){
                ith.prev.next = newNode;
            }
            ith.prev = newNode;
            size++;
        }
    }

    private Node findNode(int index) {
        if ((size >> 1) > index) {
            Node x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = last;
            for (int i = size-1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            Node ith = findNode(index);
            if (ith.prev == null) {
                head = head.next;
            } else {
                ith.prev.next = ith.next;
            }
            if (ith.next == null) {
                last = last.prev;
            } else {
                ith.next.prev = ith.prev;
            }
            size--;
        }
    }

    class Node {
        int val;
        Node prev;
        Node next;

        Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args){
        MyDoublyList linkedList = new MyDoublyList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        linkedList.get(1);            //返回2
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        linkedList.get(1);            //返回3
//        System.out.println(linkedList.get(1));
        linkedList.get(0);
        linkedList.addAtIndex(1,2);
        linkedList.get(0);
        linkedList.addAtIndex(0,1);
        linkedList.get(1);
        linkedList.get(0);
        linkedList.get(1);
    }
}
