package pr.iceworld.fernando.leetcode.simple;

public class Simple_21 {
    public static void main(String[] args) {
        ListNode list10 = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(4);

        ListNode list20 = new ListNode(1);
        ListNode list21 = new ListNode(3);
        ListNode list22 = new ListNode(4);

        list10.next = list11;
        list11.next = list12;

        list20.next = list21;
        list21.next = list22;

        //System.out.println(list10);

        System.out.println(mergeTwoLists(list10, list20));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;

        return mergeTwoLists0(list1, list2);
    }

    private static ListNode mergeTwoLists0(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode index = new ListNode();
        while (true) {
            if (list2 == null) break;
            if (list1.val == list2.val) {
                result.val = list1.val;
                result.next = new ListNode(list2.val);
                list1 = list1.next;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                while (list1.val < list2.val) {
                    result.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
            } else if (list1.val > list2.val) {
                while (list1.val > list2.val) {
                    result.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

}
