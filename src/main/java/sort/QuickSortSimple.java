package sort;

import org.apache.log4j.Logger;

public class QuickSortSimple {
    private static Logger log = Logger.getLogger(QuickSortSimple.class);

    static int[] arr;

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public int partition(int start, int end) {
        int low = start, high = end;
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            swap(low, high);
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            swap(low, high);
        }
        printLog(arr);
        return low;
    }

    public void quick_sort_recursive(int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(start, end);
        quick_sort_recursive(start, pivot - 1);
        quick_sort_recursive(pivot + 1, end);

    }

    public void sort() {
        int n = 100;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        quick_sort_recursive(0, arr.length - 1);
    }

    public void printLog(int[] a) {
        StringBuilder b = new StringBuilder();
        for (int i : arr) {
            b.append(i).append(" ");
        }
        log.info(b.toString());
    }

    public static void main(String[] args) {

        QuickSortSimple S = new QuickSortSimple();
        S.sort();
        for (int i : arr) {
            log.info(i);
        }
    }

}
