package arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
        var arr = new int[]{7, 2, 3, 1, 4, 6, 5};

        System.out.println(minimumSwaps(arr));
    }

    private static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) {
                // integer is at correct index.
                continue;
            }
            // else swap and place integer i into its index i-1
            swap(arr, i, arr[i] - 1);
            // to make sure if correct element came to i index, decrement i
            i--;
            // increment counter
            count++;
        }
        return count;
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
