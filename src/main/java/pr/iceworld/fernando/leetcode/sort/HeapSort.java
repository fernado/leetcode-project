package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * <pre>
 * 原理：基本原理也是选择排序，只不过不需用使用便利的方式来查找最大元素，而是通过堆的性质来找无序区间的最大数。
 * 如果升序排列就需要构建大堆，降序排列就要构建小堆。
 * 基本步骤：
 * 1.首先将无序区间构建成一个大根堆，这时整个堆顶元素就是最大的元素
 * 2.将堆顶的元素与最后一个元素交换，此时最后一个元素就是最大的数，
 *   无序区间的元素会变成n-1个，再将无序区间进行向下调整
 * 3.反复进行第2步，直到整个序列变得有序
 * 举例:给定一个序列 {4,2,6,9,1,3,5,8}
 * 第一步：构建大根堆，形成新的序列{9,8,5,6,1,3,4,2}
 *        9
 *     8     5
 *   6   1 3   4
 * 2
 * ---------------- 9,8,5,6,1,3,4,2
 * 第二步，交换堆顶元素和最后一个元素，并对无序区间进行向下调整
 *         8
 *      6     5
 *   2    1 3   4
 * ----------------  8,6,5,2,1,3,4,{9}
 * 第三步，重复第二步的操作
 *         6
 *      4     5
 *   2    1 3
 * ---------------- 6,4,5,2,1,3,{8,9}
 *         5
 *      4     3
 *   2    1
 * ---------------- 5,4,3,2,1,{6,8,9}
 *         4
 *      2     3
 *   1
 * ---------------- 4,2,3,1,{5,6,8,9}
 *         3
 *      2     1
 * ---------------- 3,2,1,{4,5,6,8,9}
 *         2
 *      1
 * ---------------- 2,1,{3,4,5,6,8,9}
 *         1
 * ---------------- 1,{2,3,4,5,6,8,9}
 * 最后只有一个结点，排序完成，最终序列为{1,2,3,4,5,6,8,9}
 *
 * 注意：上述过程中每次交换完成后，最后一个元素并未在堆中呈现，但是在整个序列中是存在的，只不过由于是有序区间，所以不必在堆中呈现
 * 时间复杂度 O (nlgn)
 *
 * </pre>
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] values = {4, 2, 6, 9, 1, 3, 5, 8};
        sort.heapSort(values);
        Arrays.stream(values).forEach(e -> System.out.print(e + " "));
    }

    public void heapSort(int[] array) {
        // 1. 建立大堆
        createBigHeap(array);

        // 2. 遍历 n - 1 次
        for (int i = 0; i < array.length - 1; i++) {
            // 2.1 交换之前的无序区间 [0, n - i)
            swap(array, 0, array.length - i - 1);
            // 交换之后的无序区间 [0, n - i - 1)，元素个数 n - i - 1 个
            // 2.1 对堆的 [0] 进行向下调整，堆里的元素个数就是无序区间的元素个数
            shiftDown(array, array.length - i - 1, 0);
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    //进行向下调整
    private void shiftDown(int[] array, int size, int index) {
        while (2 * index + 1 < size) {
            int maxIdx = 2 * index + 1;
            int right = maxIdx + 1;
            if (right < size && array[right] > array[maxIdx]) {
                maxIdx = right;
            }

            if (array[index] >= array[maxIdx]) {
                return;
            }

            swap(array, index, maxIdx);

            index = maxIdx;
        }
    }

    //创建大根堆
    private void createBigHeap(int[] array) {
        // 从最后一个元素的双亲开始
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }
}
