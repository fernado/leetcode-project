package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * 将一个序列 的第一个元素看做有序，将剩下的元素看做一个无序区间；
 * 然后从无须区间的第一个元素开始与有序区间的元素依次向前比较，若比前面的元素小，
 * 就将比他大的元素整体向后移动一位，再将该元素插入到正确的位置，则有序区间元素逐渐增加，
 * 无序区间元素逐渐减少，直到无序区间不存在任何元素，此时整个序列变为一个升序序列。
 * <p>
 * 时间复杂度 O(n^(1-2))
 */
public class InsertSort {

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] values = {4, 2, 6, 9, 1, 3, 5, 8};
        sort.insertSort(values);
        System.out.println("--------------");
        Arrays.stream(values).forEach(e -> System.out.print(e + " "));
    }

    public void insertSort(int[] array) {
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        System.out.println();
        // 一共要取多少个元素来进行插入过程（无序区间里有多少个元素）
        for (int i = 0; i < array.length - 1; i++) {
            // 有序区间 [0, i]  至少在 i == 0 的时候得有一个元素
            // 无序区间 [i + 1, n)
            // 先取出无序区间的第一个元素，记为 k
            int k = array[i + 1];
            // 从后往前，遍历有序区间
            // 找到合适的位置退出
            // 所谓合适的位置，就是第一次 k >= array[j] 的位置

            int j;
            for (j = i; j >= 0 && k < array[j]; j--) {
                array[j + 1] = array[j];        // 将不符合条件的数据往后搬一格
            }

            array[j + 1] = k;

            Arrays.stream(array).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}
