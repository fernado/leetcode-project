package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * <pre>
 * 原理：希尔排序可以理解为插入排序的升级版（分组插入排序），也称为缩小增量排序。
 *
 * 将整个区间分为若干个区间（由相隔某个“增量”的元素组成），然后对这些子序列分别进行插入排序。完成后缩小增量的值，
 * 而此时又会形成若干个区间，重复之前的操作，直到增量为1时，对整个序列来一次插入排序，而此时的插入排序效率最高，
 * 因为整个序列已经有了基本的顺序，达到了一种有序的状态。
 *
 * 通常用gap表示增量，当一个序列有n个元素时，进行第一次排序时gap=n/2，之后gap=gap/2.
 * 例：{4,2,6,9,1,3,5,8} 此时gap=8/2=4,
 * 可以分为四组 {4,1}、{2,3}、{6,5}、{9,8}
 * 进行组内排序形成一个新的序列{1,2,5,8,4,3,6,9}，此时gap=gap/2=2，
 * 可以将序列分成两组 {1,5,4,6}、{2,8,3,9}
 * 经过排序后又会形成一个新的序列 {1,2,4,3,5,8,6,9}，
 * 此时gap=2/2=1，则一整个序列为一组，但整个序列看上去已经显得部分有序，
 * 最后再进行一次插入排序，就能将整个序列变得有序。
 * 得到的有序序列为：{1,2,3,4,5,6,8,9}。
 *
 * 时间复杂度 O(n^(2/3))
 * </pre>
 */
public class ShellSort {
    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] values = {4, 2, 6, 9, 1, 3, 5, 8};
        sort.shellSort(values);
        Arrays.stream(values).forEach(e -> System.out.print(e + " "));
    }

    public void shellSort(int[] arr) {
        int j, temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {    //每一次的增量
            for (int i = gap; i < arr.length; i++) {    //从下标为增量的元素开始向后遍历
                temp = arr[i];    //提前保存 arr[i]，否则会将其覆盖
                for (j = i - gap; j >= 0; j -= gap) {    //寻找插入位置
                    if (temp < arr[j]) {    //满足条件进行下一步
                        arr[j + gap] = arr[j];    //将元素后移
                    } else {
                        break;
                    }
                }
                arr[j + gap] = temp;    //插入 arr[i]
            }
        }
    }
}
