package pr.iceworld.fernando.leetcode.normal;

import pr.iceworld.fernando.leetcode.tree.TreeNode;

public class Normal_654 {
    public static void main(String[] args) {
        Normal_654 normal_654 = new Normal_654();
        int[] nums = {3, 2, 1, 6, 0, 5};
        //[6,3,5,null,2,0,null,null,1]
        //TreeNode{data=6, left=TreeNode{data=3, left=null, right=TreeNode{data=2, left=null, right=TreeNode{data=1, left=null, right=null}}}, right=TreeNode{data=5, left=TreeNode{data=0, left=null, right=null}, right=null}}
        System.out.println(normal_654.constructMaximumBinaryTree(nums));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, true);
    }

    private TreeNode construct(int[] nums, boolean flag) {
        if (nums.length == 0) return null;
        int[] roots = choose(nums);
        if (roots.length == 0) {
            return null;
        }
        TreeNode root = createTreeNode(roots);
        int[] _left = new int[roots[1]];
        if (_left.length > 0) {
            for (int i = 0; i < _left.length; i++) {
                _left[i] = nums[i];
            }
            root.left = construct(_left, true);
        }

        int[] _right = new int[nums.length - roots[1] - 1];
        if (_right.length > 0) {
            for (int i = 0, j = roots[1] + 1; j < nums.length; i++, j++) {
                _right[i] = nums[j];
            }
            root.right = construct(_right, _right.length > 1);
        }
        return root;
    }

    private TreeNode createTreeNode(int[] roots) {
        return new TreeNode(roots[0]);
    }

    private int[] choose(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int temp = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > temp) {
                temp = nums[i];
                index = i;
            }
        }
        return new int[]{temp, index};
    }

}
