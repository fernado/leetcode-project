package pr.iceworld.fernando.leetcode.link;

public class CircleLink {

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(-4);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        CircleLink circleLink = new CircleLink();
        int ll = circleLink.detectCycle(listNode0);
        System.out.println(ll);
    }

    public int detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (fast != null && fast.next != null) {
            i++;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    i++;
                    index1 = index1.next;
                    index2 = index2.next;
                }
                System.out.println(i);
                return index1.val;
            }
        }
        return -100;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }


        //@Override
        //public String toString() {
        //    final StringBuilder sb = new StringBuilder("ListNode{");
        //    sb.append("val=").append(val);
        //    sb.append(", next=").append(next);
        //    sb.append('}');
        //    return sb.toString();
        //}
    }
}
