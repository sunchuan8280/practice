package sort;

import org.apache.log4j.Logger;

public class QuickSort {
    private static Logger log = Logger.getLogger(QuickSort.class);

    static int[] arr = new int[10];

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void quick_sort_recursive(int start, int end) {
        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] < mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            swap(left, right);
        }
        if (arr[left] >= arr[end])
            swap(left, end);
        else
            left++;
        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left + 1, end);
    }

    public void sort() {
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        quick_sort_recursive(0, arr.length - 1);
    }

    public static void main(String[] args) {

        QuickSort S = new QuickSort();
        S.sort();
        for (int i : arr) {
            log.info(i);
        }
    }

}
