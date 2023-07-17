package pr.iceworld.fernando.leetcode.tree;

/**
 * 前序加中序可以逆推二叉树
 * 后序加中序可以逆推二叉树   此程序未能实现
 * 前序加后序不能逆推二叉树
 */
public class InverseBinaryTree {

    int key = 0;
    String value = "";

    public static void main(String[] args) {
        InverseBinaryTree inverseBinaryTree = new InverseBinaryTree();
        inverseBinaryTree.preOrdersAndMidOrders();
        inverseBinaryTree.postOrdersAndMidOrders();
    }

    public void preOrdersAndMidOrders() {
        int[] preOrders = {4, 2, 1, 3, 5, 6};
        int[] midOrders = {1, 2, 3, 4, 5, 6};
        key = 0;
        value = "";
        recordPreMidLocation(preOrders, midOrders);
        System.out.println(value);
    }

    public void postOrdersAndMidOrders() {
        int[] midOrders = {1, 2, 3, 4, 5, 6};
        int[] postOrders = {1, 3, 2, 6, 5, 4};
        key = 0;
        value = "";
        recordPostMidLocation(postOrders, midOrders);
        System.out.println(value);
    }

    //记录前序中的位置
    public TreeNode recordPreMidLocation(int[] preOrders, int[] midOrders) {
        return recordPreMidLocation0(preOrders, midOrders, 0, midOrders.length - 1);
    }

    public TreeNode recordPostMidLocation(int[] postOrders, int[] midOrders) {
        return recordPostMidLocation0(postOrders, midOrders, 0, midOrders.length - 1);
    }

    public TreeNode recordPreMidLocation0(int[] preOrders, int[] midOrders, int left, int right) {
        if (left == right) {
            TreeNode treeNode = new TreeNode(preOrders[key]);
            key++;
            value = value + treeNode.data + " ";
            return treeNode;
        } else if (left > right)
            return null;
        int rootIndex = 0;
        for (int i = left; i <= right; i++) {
            if (midOrders[i] == preOrders[key]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preOrders[key]);
        key++;
        root.left = recordPreMidLocation0(preOrders, midOrders, left, rootIndex - 1);
        root.right = recordPreMidLocation0(preOrders, midOrders, rootIndex + 1, right);
        if (root.left == root.right)
            key--;
        value = value + root.data + " ";
        return root;
    }

    public TreeNode recordPostMidLocation0(int[] postOrders, int[] midOrders, int left, int right) {
        if (left == right) {
            TreeNode treeNode = new TreeNode(postOrders[key]);
            key++;
            value = value + treeNode.data + " ";
            return treeNode;
        } else if (left > right)
            return null;
        int rootIndex = 0;
        for (int i = left; i <= right; i++) {
            if (midOrders[i] == postOrders[key]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postOrders[key]);
        key++;
        root.left = recordPostMidLocation0(postOrders, midOrders, left, rootIndex - 1);
        value = value + root.data + " ";
        root.right = recordPostMidLocation0(postOrders, midOrders, rootIndex + 1, right);
        if (root.left == root.right)
            key--;
        return root;
    }

}
