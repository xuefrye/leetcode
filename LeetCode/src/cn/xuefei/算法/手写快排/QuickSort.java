package cn.xuefei.算法.手写快排;

/**
 * @author: xuefei
 * @date: 2020-08-31
 * @version: 1.0
 * @description: TODO
 */
public class QuickSort {

    void sort(int[] arr, int start, int end) {
        if (start > end) return;

        int[] p = partition(arr, start, end);


        sort(arr, start, p[0]);
        sort(arr, p[1], end);
    }

    void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        sort(arr, 0, arr.length - 1);
    }

    int[] partition(int[] arr, int start, int end) {
        int L = start - 1;
        int R = end + 1;
        int index = start;
        int num = arr[index];

        while (index < R) {
            if (arr[index] == num) {
                index++;
            } else if (arr[index] < num) {
                swap(arr, index++, ++L);
            } else {
                swap(arr, index, --R);
            }
        }

        return new int[]{L, R};
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{};
        quickSort.sort(null);
        System.out.println(arr);
    }
}
