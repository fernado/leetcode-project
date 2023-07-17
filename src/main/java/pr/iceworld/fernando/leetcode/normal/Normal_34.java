package pr.iceworld.fernando.leetcode.normal;

import pr.iceworld.fernando.leetcode.tree.TreeNode;

public class Normal_34 {
    public static void main(String[] args) {
        Normal_34 normal_654 = new Normal_34();
        int[] nums = {5,2,3,4};
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode3;
        treeNode.right = treeNode2;
        System.out.println(normal_654.maxValue(treeNode, 2));
    }

    public int maxValue(TreeNode root, int k) {

        int[] vl = new int[k];
        int[] vr = new int[k];
        vl[0] = root.data;
        vr[0] = root.data;
        int lIndex = 1;
        int rIndex = 1;
        int temp = 0;
        while(true) {
            temp = getValue(root.left);
            if (temp == 0) {
                lIndex--;
                break;
            }
            vl[lIndex++] = temp;
        }
        while (true) {
            temp = getValue(root.right);
            if (temp == 0) {
                rIndex--;
                break;
            }
            vl[rIndex++] = temp;
        }

        int[] vv = new int[lIndex + rIndex - 1];
        for (int i = 0, j = vl.length - 1; i < vl.length; i++, j--) {
            vv[i] = vl[j];
        }
        for (int i = vl.length, j = 0; j < vr.length - 1; i++, j++) {
            vv[i] = vr[j];
        }

        for (int i = 0; i < vv.length; i++) {
            temp = 0;

            for (int j = 0; j < k; j++) {
                if (j + i > vv.length) {
                    break;
                }
                temp += vv[j + i];
            }

        }


        return 0;
    }



    private int getValue(TreeNode root) {
        int result = 0;
        if (null == root) {
            return result;
        }
        return root.data;
    }

}
