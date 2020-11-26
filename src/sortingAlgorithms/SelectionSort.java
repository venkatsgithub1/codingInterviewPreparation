package sortingAlgorithms;

public class SelectionSort {
    public static void main(String[] args) {
        int[] x = new int[]{5, 6, 1, 3, 2};
        sort(x);
        printArr(x);
        int[] y = new int[]{2, 7, 4, 1, 5, 3};
        sort(y);
        printArr(y);
        int[] z = new int[]{9, 6, 3, 4};
        sort(z);
        printArr(z);
    }

    private static void printArr(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr) {
        for (int a = 0; a < arr.length - 1; a++) {
            int smallest = a;
            for (int b = a + 1; b < arr.length; b++) {
                if (arr[smallest] > arr[b]) {
                    smallest = b;
                }
            }

            if (smallest != a) {
                swap(a, smallest, arr);
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
