package linkedlist;

public class ReverseList {

    //迭代解法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        while (temp.next != null) {
            ListNode temp1 = temp.next;
            temp.next = temp1.next;
            temp1.next = head;
            head = temp1;
        }
        return head;
    }
    //递归解法
    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        ListNode prev = reverseList1(head.next);
        //将下一个节点放在传入节点之前
        head.next.next = head;
        head.next = null;
        return prev;
    }
}
