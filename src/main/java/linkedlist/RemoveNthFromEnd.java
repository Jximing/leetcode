package linkedlist;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if(n==count){
            return head.next;
        }
        temp = head;
        for (int i = 0; i < count - n - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    //比较牛的做法
    int length = 0;
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        helper(node,0,n);
        return node.next;
    }

    void helper(ListNode node,int index,int n){
        if(node.next == null) {
            length = index;
            return;
        }
        helper(node.next, index+1,n);
        if(index == length - n)
            node.next = node.next.next;
    }
}
