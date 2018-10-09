package linkedlist;

public class RemoveElements {
    //递归解法
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val == val) {
            head = head.next;
        }
        if(head==null){
            return null;
        }
        ListNode prev = head;
        ListNode next = head.next;
        while (next!=null){
            while (next.val==val){
                next=next.next;
            }
            prev.next = next;
            prev=prev.next;
            if(prev==null)
                break;
            next = next.next;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp = new ListNode(2);
        head.next = temp;
        temp.next = new ListNode(6);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(6);
        RemoveElements re = new RemoveElements();
        re.removeElements(head,6);
    }
}
