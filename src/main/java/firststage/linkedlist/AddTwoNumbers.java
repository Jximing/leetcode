package firststage.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode mv = res;
        boolean carry = false;
        while (l1!=null||l2!=null){
            int val = 0;
            if(l1!=null&&l2!=null){
                val = l1.val+l2.val;
                if(carry){
                    val++;
                    carry = false;
                }
                if(val>=10){
                    carry = true;
                }
                mv.next = new ListNode(val%10);
                mv = mv.next;
                l1 = l1.next;
                l2 = l2.next;
            }else {
                while (l1!=null){
                    val = l1.val;
                    if(carry){
                        val++;
                        carry = false;
                    }
                    if(val>=10){
                        carry = true;
                    }
                    mv.next = new ListNode(val%10);
                    mv = mv.next;
                    l1 = l1.next;
                }
                while (l2!=null){
                    val = l2.val;
                    if(carry){
                        val++;
                        carry = false;
                    }
                    if(val>=10){
                        carry = true;
                    }
                    mv.next = new ListNode(val%10);
                    mv = mv.next;
                    l2 = l2.next;
                }
            }
        }
        if(carry){
            mv.next = new ListNode(1);
        }
        return res.next;
    }

    //更好的解法
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode rs = null;
        ListNode last = null;
        ListNode cur = null;
        int val = 0;
        while (null != l1 || null != l2) {
            if (null != l1) {
                val += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                val += l2.val;
                l2 = l2.next;
            }
            cur = new ListNode(val % 10);
            val = val / 10;
            if (null == last) {
                rs = cur;
            } else {
                last.next = cur;
            }
            last = cur;
        }
        if (val > 0) {
            cur = new ListNode(val);
            last.next = cur;
        }
        return rs;
    }
}
