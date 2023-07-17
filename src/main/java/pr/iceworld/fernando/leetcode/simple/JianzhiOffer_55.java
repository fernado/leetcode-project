package pr.iceworld.fernando.leetcode.simple;

public class JianzhiOffer_55 {
    public static void main(String[] args) {
        JianzhiOffer_55 offer_55 = new JianzhiOffer_55();
        //TreeNode case1 = offer_55.case1();
        //TreeNode case2 = offer_55.case2();
        //TreeNode case3 = offer_55.case3();
        //TreeNode case4 = offer_55.case4();
        TreeNode case5 = offer_55.case5();
        System.out.println(offer_55.isBalanced(case5));
    }

    private TreeNode case1() {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node5;
        node2.right = node6;
        return root;
    }

    private TreeNode case2() {
        //1,2,2,3,3,null,null,4,4
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;
        return root;
    }

    /**
     * <pre>
     *            1
     *              2
     *                3
     * </pre>
     * @return
     */
    private TreeNode case3() {
        //[1,null,2,null,3]
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.right = node2;
        return root;
    }

    /**
     * <pre>
     *     [1,2,2,3,3,null,null,4,4]
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     *  n = 1
     *  n = 2, left = 3, right = 3
     *  n = 2, left = null, right = null
     *  n = 3, left = 4, right = 4
     *  //[1,2,2,3,null,null,3,4,null,null,4]
     *             1
     *          2     2
     *       3           3
     *     4                4
     *
     *
     *
     * </pre>
     * @return
     */
    private TreeNode case4() {
        //[1,2,2,3,null,null,3,4,null,null,4]
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node5;
        node2.right = node4;
        node4.right = node6;
        return root;
    }

    private TreeNode case5() {
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        if (null == root) return false;

        int left = height(root.left);
        int right = height(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        }
        return true;
    }

    private int height(TreeNode node) {
        if (null == node) return 0;
        int left = 1;
        int right = 1;
        if (null != node.left) {
            left += height(node.left);
        }
        if (null != node.right) {
            right += height(node.right);
        }
        return left > right ? left : right;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
