package firststage.linkedlist;


public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null|| head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even =head.next;
        ListNode tempEven =head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = tempEven;
        return head;
    }

    //另一种思路
    public ListNode oddEvenList2(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        if(head.next.next == null)
            return head;
        ListNode headodd = head;
        ListNode odd = headodd;
        head = head.next;
        ListNode headeve = head;
        ListNode eve = headeve;
        head = head.next;
        boolean boo = false;
        while(head != null)
        {
            if(boo == false)
            {
                odd.next = head;
                odd = odd.next;
                head = head.next;
                boo = true;
            }
            else
            {
                eve.next = head;
                eve = eve.next;
                head = head.next;
                boo = false;
            }
        }
        odd.next = headeve;
        eve.next = null;
        return headodd;
    }
}
