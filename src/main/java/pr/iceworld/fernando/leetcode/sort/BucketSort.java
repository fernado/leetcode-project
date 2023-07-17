package pr.iceworld.fernando.leetcode.sort;

import java.util.Arrays;

/**
 * <pre>
 * 桶排序，是一种基于非比较的排序方式，时间复杂度O(n)，因此它是是属于一种“线性排序”。
 *
 * 思想：桶排序的思想是将一组数据分到几个有序的桶里，每个桶里的数据再单独进行快速排序。每个桶内都排序完成后，
 * 再加上本身桶之间已经是有序的，那么按照桶的顺序依次取出每个桶内的数据，最终组成的序列就是有序的。
 *
 * 桶排序的时间复杂度分析：
 * 假如排序数组的元素个数为n，均匀分布在个数为m的桶中，那么每个桶中的元素个数为k=n/m,
 * 因为每个桶快速排序的时间复杂度为klogk即n/mlog(n/m),那么m个桶一起就是nlog(n/m),
 * 假如桶的个数m跟元素个数n十分接近，那么最终的时间复杂度为O(n).
 *
 * 如果极端情况下，所有的元素n个都分在一个桶里呢？这种情况下时间复杂度就退化成O(nlogn)了。
 * 所以，可以看出桶排序对数据及其分布的要求是十分苛刻的：
 * 1  要求各个桶之间是有序的，这样每个桶排好序之后，才可以直接根据桶的顺序得到最终排序。
 * 2 每个桶之间数据分布式平均的，如果出现上述极端情况，则时间复杂度就会退化为O(nlogn)了。
 * </pre>
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 1, 9, 5, 3, 7, 6, 1};
        int bucketSize = arr.length + arr.length / 3 + 1;
        bucketSort(arr, bucketSize);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    /**
     * @param arr        数组
     * @param bucketSize 桶大小
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 2) {
            return;
        }

        // 数组最小值
        int minValue = arr[0];
        // 数组最大值
        int maxValue = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // 桶数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        // 将数组中值分配到各个桶里
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        // 对每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            quickSortC(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }

    /**
     * 数组扩容
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    /**
     * 快速排序递归函数
     *
     * @param arr
     * @param p
     * @param r
     */
    private static void quickSortC(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(arr, p, r);
        quickSortC(arr, p, q - 1);
        quickSortC(arr, q + 1, r);
    }

    /**
     * 分区函数
     *
     * @param arr
     * @param p
     * @param r
     * @return 分区点位置
     */
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
