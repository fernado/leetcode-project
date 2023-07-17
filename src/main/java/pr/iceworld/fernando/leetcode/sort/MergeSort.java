package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * <pre>
 * 原理：归并排序的核心思想是分治。
 * 将整个区间划分成与若干个小区间，对每个区间进行排序，
 * 然后进行合并（合并区间的原理是合并有序数组）。若一个区间有6个元素，那么最终会划分成6个区间，
 * 每个区间都是一个单独的元素，而每个区间也都成了有序区间。之后进行合并，合并后成为了3个区间，
 * 每两个元素为一个区间，对3个区间进行排序，形成了三个有序的区间。重复上述操作，
 * 直到合并成为一个区间，最后在进行一次排序，即可将整个序列变为一个有序的序列。
 *
 * 时间复杂度 O(nlgn)
 * </pre>
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] values = {4, 2, 6, 9, 1, 3, 5, 8};
        sort.mergeSortRange(values, 0, values.length);
        Arrays.stream(values).forEach(e -> System.out.print(e + " "));
    }

    //处理待合并的区间
    public void mergeSortRange(int[] array, int from, int to) {
        int size = to - from;
        if (size == 1) {
            return;
        }

        int mid = from + (size / 2);

        mergeSortRange(array, from, mid);
        mergeSortRange(array, mid, to);

        merge(array, from, mid, to);
    }

    //合并有序数组
    public void merge(int[] array, int from, int mid, int to) {
        int size = to - from;
        int[] other = new int[size];

        int left = from;  //左边小区间的下标
        int right = mid;  //右边小区间的下标
        int dest = 0;     //临时空间的下标

        while (left < mid && right < to) {
            if (array[left] < array[right]) {
                other[dest++] = array[left++];
            } else {
                other[dest++] = array[right++];
            }
        }

        while (left < mid) {
            other[dest++] = array[left++];
        }
        while (right < to) {
            other[dest++] = array[right++];
        }

        for (int i = 0; i < size; i++) {
            array[from + i] = other[i];
        }
    }
}
