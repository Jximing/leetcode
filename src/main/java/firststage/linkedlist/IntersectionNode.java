package firststage.linkedlist;

public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tA = headA;
        ListNode tB = headB;
        int count = 0;
        while (tA!=tB&&count<3){
            tA = tA.next;
            tB = tB.next;
            if(tA==null){
                tA = headB;
                count++;
            }
            if(tB==null){
                tB = headA;
                count++;
            }
        }
        return count<3?tA:null;
    }
}
