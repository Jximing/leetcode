package firststage.linkedlist;

public class MyLinkedList {

    private int val;
    private MyLinkedList next;
    private MyLinkedList head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        next = null;
        head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        MyLinkedList ml = head;
        for (int i = 0; i < index; i++) {
            ml = ml.next;
        }
        return ml.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyLinkedList mll = new MyLinkedList();
        mll.val = val;
        mll.next = head;
        head = mll;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyLinkedList mll = new MyLinkedList();
        mll.val = val;
        MyLinkedList ml = head;
        while (ml.next!=null){
            ml = ml.next;
        }
        ml.next = mll;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index>size)
            return;
        MyLinkedList mll = new MyLinkedList();
        mll.val = val;
        if(size==0){
            head = mll;
            size++;
            return;
        }
        MyLinkedList ml = head;
        for (int i =0;i<index-1;i++){
            ml = ml.next;
        }
        mll.next = ml.next;
        ml.next = mll;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if(index>=size)
            return;
        MyLinkedList ml = head;
        for (int i =0;i<index-1;i++){
            ml = ml.next;
        }
        ml.next = ml.next.next;
        size--;
    }

    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        linkedList.get(1);            //返回2
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        linkedList.get(1);            //返回3
        linkedList.get(0);
        linkedList.addAtIndex(1,2);
        linkedList.get(0);
        linkedList.get(1);
        linkedList.addAtIndex(0,1);
        linkedList.get(0);
        linkedList.get(1);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
