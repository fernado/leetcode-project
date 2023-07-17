package pr.iceworld.fernando.leetcode.normal;

public class JianzhiOffer_07 {

    public static void main(String[] args) {
        //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //Output: [3,9,20,null,null,15,7]


        JianzhiOffer_07 jianzhiOffer_07 = new JianzhiOffer_07();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        //int[] preorder = {1,2,3};
        //int[] inorder = {1,3,2};
        System.out.println(jianzhiOffer_07.buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int[] preordersl = new int[index];
        int[] inordersl = new int[index];
        int[] preordersr = new int[length - index - 1];
        int[] inordersr = new int[length - index];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0 && i <= index) {
                preordersl[i1++] = preorder[i];
            }
            if (i < index) {
                inordersl[i2++] = inorder[i];
            }
            if (i > index) {
                preordersr[i3++] = preorder[i];
            }
            if (i >= 1 && i >= index) {
                inordersr[i4++] = inorder[i];
            }
        }
        if (preordersl.length > 0 && inordersl.length > 0) {
            root.left = buildTree(preordersl, inordersl);
        }
        if (preordersr.length > 0 && inordersr.length > 0) {
            root.right = buildTree(preordersr, inordersr);
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TreeNode{");
            sb.append("val=").append(val);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }
}
