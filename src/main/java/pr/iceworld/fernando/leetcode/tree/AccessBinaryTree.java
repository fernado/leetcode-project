package pr.iceworld.fernando.leetcode.tree;


public class AccessBinaryTree {

    private void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        visit(treeNode);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    private void midOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midOrder(treeNode.left);
        visit(treeNode);
        midOrder(treeNode.right);
    }

    private void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        visit(treeNode);
    }

    private void visit(TreeNode treeNode) {
        value = value + treeNode.data + " ";
    }

    private static String value = "";

    //中序遍历
    //4 -> 2 -> 1 -> 3 -> 5 -> 6
    //1 -> 2 -> 3 -> 4 -> 5 -> 6
    //1 -> 3 -> 2 -> 6 -> 5 -> 4
    public static void main(String[] args) {
        AccessBinaryTree accessBinaryTree = new AccessBinaryTree();
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(1);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);
        TreeNode right3 = new TreeNode(6);
        root.left = left1;
        root.right = right2;
        left1.left = left2;
        left1.right = right1;
        right2.right = right3;
        System.out.print("pre order = ");
        accessBinaryTree.preOrder(root);
        System.out.println(value);
        value = "";
        System.out.print("mid order = ");
        accessBinaryTree.midOrder(root);
        System.out.println(value);
        value = "";
        System.out.print("post order = ");
        accessBinaryTree.postOrder(root);
        System.out.println(value);
    }

}
