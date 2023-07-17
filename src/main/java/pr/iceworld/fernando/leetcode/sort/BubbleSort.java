package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * 从前往后，相邻的两个元素进行比较，满足升序或降序；（这里以升序为例）一次冒泡的
 * 过程，至少可以保证把一个元素放到正确的位置；再升序的前提下，则每次冒泡是将大的元素往后移动。
 * 时间复杂度 O (n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] values = {4, 3, 7, 2, 5, 1, 8, 11, 9};
        sort.bubbleSort(values);
        Arrays.stream(values).forEach(e -> System.out.print(e + " "));
    }

    public void bubbleSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] > values[j]) {
                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
    }
}
