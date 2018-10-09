package linkedlist;

public class Palindrome {

    private ListNode pre;

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        pre = head;
        return helper(head.next);
    }

    private boolean helper(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean ispd = helper(head.next);
        ispd = ispd ? pre.val == head.val : ispd;
        if (ispd)
            pre = pre.next;
        return ispd;
    }

    //更好的做法
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        //此时slow走了一半，将后一半反转
        ListNode reverseHead = reverse(slow);
        while (reverseHead != null) {
            if (reverseHead.val != head.val) return false;
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        //反转链表的头节点
        ListNode reverseHead = null;
        //下一个要插入的节点
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = reverseHead;
            reverseHead = p;
            p = tmp;
        }
        return reverseHead;
    }
}
