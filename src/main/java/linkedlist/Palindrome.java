package linkedlist;

public class Palindrome {

    private ListNode pre;

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        pre = head;
        return helper(head.next);
    }

    private boolean helper(ListNode head) {
        if(head==null){
            return true;
        }
        boolean ispd = helper(head.next);
        ispd = ispd ? pre.val == head.val : ispd;
        if (ispd)
            pre = pre.next;
        return ispd;
    }
}
