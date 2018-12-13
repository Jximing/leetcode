package firststage.linkedlist;

public class CircleList {
    public boolean hasCycle(ListNode head) {
        if (head == null||head.next==null)
            return false;
        ListNode temp = head;
        while (temp != null&&temp.next!=null) {
            head = head.next;
            temp = temp.next;
            if (temp == head) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ListNode ln = new ListNode(3);
        ln.next = ln;
        CircleList cl = new CircleList();
        System.out.println(cl.hasCycle(ln));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
