package linkedlist;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        temp.next = head;
        for (int i = 0; i < (count - k % count); i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    //better method
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            // the length of this link list
            len++;
            pre = current;
            current = current.next;
        }

        //change single link list to cycle link list
        pre.next = head;
        //rotate right has cycle
        k = k % len;
        k = len - k;
        while (k > 0) {
            pre = head;
            head = head.next;
            k--;

        }
        // change from cycle link list to single link list.
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(4);
        ListNode next3 = new ListNode(5);
        head.next = next;
        next.next = next1;
        next1.next = next2;
        next2.next = next3;
        RotateRight rr = new RotateRight();
        rr.rotateRight(head, 6);
    }
}
