package linkedlist;

public class Flatten {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node child = head.child;
        if(child!=null){
            Node temp = head.next;
            head.next = child;
            head.child = null;
            child.prev = head;
            if(temp!=null){
                Node mv = head;
                while (mv.next!=null){
                    mv = mv.next;
                }
                mv.next = temp;
                temp.prev = mv;
            }
        }
        flatten(head.next);
//        if(head.child!=null){
//            Node temp = head.next;
//            Node child = head.child;
//            head.next = child;
//            head.child = null;
//            child.prev = head;
//            Node mv = head;
//            while (mv.next!=null){
//                flatten(head.next);
//                mv = mv.next;
//            }
//            mv.next = temp;
//        }
        return head;
    }

}

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
