package linkedlist;

public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head =null;
        if(l1.val>l2.val){
            head = l2;
            l2=l2.next;
        }else if(l1.val<=l2.val){
            head = l1;
            l1=l1.next;
        }
        ListNode t = head;
        while (l1 != null && l2 != null) {
            while (l1!=null&&l1.val<=l2.val){
                t.next = l1;
                l1=l1.next;
                t=t.next;
            }
            if (l1 == null) {
                break;
            }
            while (l2!=null&&l1.val>l2.val){
                t.next = l2;
                l2=l2.next;
                t=t.next;
            }
        }
        if(l2==null){
            t.next=l1;
        }
        if (l1 == null) {
            t.next = l2;
        }
        return head;
    }

    //别人更好的解法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode listNode = new ListNode(0);
        ListNode firstNode=listNode;
        while(l1!=null||l2!=null){
            if(l1!=null&&(l2==null||l1.val<=l2.val)){
                listNode.next=l1;
                l1=l1.next;

            }else{
                listNode.next=l2;
                l2=l2.next;
            }
            listNode=listNode.next;
        }
        return firstNode.next;
    }
    public static void main(String[] args){
        MergeTwoList mt =new MergeTwoList();
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l2.next=l21;
        l21.next=l22;
        mt.mergeTwoLists(l1,l2);
    }
}
