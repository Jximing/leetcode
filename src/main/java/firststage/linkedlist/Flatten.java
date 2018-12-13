package firststage.linkedlist;

public class Flatten {
    //递归解法
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
        return head;
    }

    //非递归解法
    public Node flatten2(Node head) {

        if(head == null)
            return head;
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            if(cur.child != null) {
                Node child = cur.child;
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                Node tmpChild = child;
                while(tmpChild != null && tmpChild.next != null) {
                    tmpChild = tmpChild.next;
                }
                tmpChild.next = next;
                if(next != null) {
                    next.prev = tmpChild;
                }
            }
            cur = cur.next;
        }
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
