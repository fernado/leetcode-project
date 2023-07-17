package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * 原理：首先将整个序列看做一个无序区间，将无序区间的第一个元素a0看做最小的，然后和后面的元素一次进行比较，
 * 若发现比a0还小的元素，就将这个元素看做最小的，继续和后面比较，若没有比该元素还小的元素，
 * 就将该元素和无序区间的第一个元素交换，此时有序区间便有了一个元素。然后重复上述操作，直到整个序列成为有序。
 * <p>
 * 时间复杂度 O (n^2)
 */
public class SelectSort {

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        int[] values = {4, 3, 7, 2, 5, 1, 8, 11, 9};
        sort.selectSort(values);
        System.out.println("--------------");
        Arrays.stream(values).forEach(e -> System.out.print(e + " "));
    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            Arrays.stream(array).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}
