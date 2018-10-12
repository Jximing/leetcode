package linkedlist;

public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head ==null){
            return null;
        }
        RandomListNode p = head;

        //1.新节点接到原对应节点的后面。
        while(p != null){
            RandomListNode clone = new RandomListNode(p.label);
            clone.next = p.next;
            //clone.random = null;

            p.next = clone;
            p = clone.next;
        }

        //2.参照原节点的random，改变新节点的rondom
        p = head;
        while(p!=null){
            p.next.random = p.random==null?null:p.random.next;
            p=p.next.next;
        }

        //3.将两部分分离
        p = head;
        RandomListNode cloneHead = head.next;
        RandomListNode cloneNode = cloneHead;
        while(p!=null){
            p.next = cloneNode.next;
            if(cloneNode.next!=null){
                cloneNode.next = cloneNode.next.next;
            }
            p = p.next;
            cloneNode = cloneNode.next;
        }

        return cloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}