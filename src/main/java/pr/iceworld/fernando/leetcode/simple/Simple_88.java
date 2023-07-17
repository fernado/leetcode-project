package pr.iceworld.fernando.leetcode.simple;

public class Simple_88 {

    public static void main(String[] args) {
        //int[] nums1 = {1,2,3,0,0,0};
        //int[] nums2 = {2,5,6};
        //merge(nums1, 6, nums2, 3);
        //int[] nums1 = {2, 0};
        //int[] nums2 = {1, 0};
        //merge(nums1, 2, nums2, 2);
        //int[] nums1 = {0, 0, 0, 0, 0};
        //int[] nums2 = {1, 2, 3, 4, 5};
        //merge(nums1, 5, nums2, 5);
        //int[] nums1 = {4,0,0,0,0,0};
        //int[] nums2 = {1,2,3,5,6};
        //merge(nums1, 6, nums2, 5);
        //int[] nums1 = {0};
        //int[] nums2 = {1};
        //merge(nums1, 0, nums2, 1);

        //int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        //int[] nums2 = {1,2,2};
        //merge(nums1, 9, nums2, 3);
        //Arrays.stream(nums1).forEach(System.out::println);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            nums1[0] = nums2[0];
        }

        int k = 0;
        int i = 0;
        int j = 0;
        int[] nums = new int[nums1.length + nums2.length];
        boolean jump = false;
        boolean nJump = false;
        boolean lastOneIsBelow0 = false;
        while (i < m + n && !nJump) {
            jump = false;
            if (i < m) {
                if (nums1[i] == 0 && !lastOneIsBelow0) {
                    i++;
                    continue;
                } else if (nums1[i] < 0) {
                    lastOneIsBelow0 = !lastOneIsBelow0;
                }
            }

            while (j < n && !jump) {
                if (nums2[j] == 0 && !lastOneIsBelow0) {
                    j++;
                } else if (nums2[j] < 0) {
                    lastOneIsBelow0 = !lastOneIsBelow0;
                } else if (i >= m) {
                    nums[k++] = nums2[j++];
                } else if (nums1[i] < nums2[j]) {
                    nums[k++] = nums1[i++];
                    jump = true;
                } else if (nums1[i] > nums2[j]) {
                    nums[k++] = nums2[j];
                    j++;
                } else {
                    nums[k++] = nums1[i];
                    nums[k++] = nums2[j];
                    i++;
                    j++;
                    jump = true;
                }
            }

            if (j == n && i < m) {
                nums[k++] = nums1[i++];
            }
            if (i == m && j < n) {
                nums[k++] = nums2[j++];
            }
            if ((j == n && i >= m) || (i == m && j >= n)) {
                break;
            }
        }

        for (int l = 0; l < nums1.length; l++) {
            nums1[l] = nums[l];
        }

    }
}
