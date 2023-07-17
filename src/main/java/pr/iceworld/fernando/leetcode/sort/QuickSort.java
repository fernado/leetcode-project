package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * <pre>
 * 快速排序是基于二分的思想，对冒泡排序的一种改进。主要思想是确立一个基数，将小于基数的数放到基数左边，
 * 大于基数的数字放到基数的右边，然后在对这两部分进一步排序，从而实现对数组的排序
 * 优点 效率高：时间复杂度平均为O(N*logN)，顾名思义，最快的排序算法；耗费资源少：最优的情况下空间复杂度为：O(logn) ，
 *      每一次都平分数组的情况；代码较为简单。
 * 缺点 不稳定，初始序列有序或基本有序时，时间复杂度降为O(n^2)。
 * </pre>
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arrays = {5, 9, 1, 9, 5, 3, 7, 6, 1};
        quickSort.quickSort(arrays, 0, arrays.length - 1);
        Arrays.stream(arrays).forEach(e -> System.out.print(e + " "));
    }

    public void quickSort(int[] arrays, int left, int right) {
        if(left > right) {
            return;
        }
        int lIndex = left;
        int rIndex = right;
        // 最左端基数，用于程序对比
        int pivot = arrays[left];
        int temp;
        while(lIndex < rIndex) {
            while(pivot <= arrays[rIndex] && lIndex < rIndex) {
                rIndex--;
            }
            while(pivot >= arrays[lIndex] && lIndex < rIndex) {
                lIndex++;
            }
            if(lIndex <= rIndex) {
                temp = arrays[rIndex];
                arrays[rIndex] = arrays[lIndex];
                arrays[lIndex] = temp;
            }
        }
        arrays[left] = arrays[lIndex];
        arrays[lIndex] = pivot;
        quickSort(arrays, left, lIndex - 1);
        quickSort(arrays, lIndex + 1, right);
    }
}
