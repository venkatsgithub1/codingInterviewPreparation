package arrays;

public class Kadanes {

    public static void main(String[] args) {
        assert (maxSubarraySum(new int[]{1, 2, 3, -2, 5}, 5) == 9);
        assert (maxSubarraySum(new int[]{-1, -2, -3, -4}, 4) == -1);
    }

    private static int maxSubarraySum(int[] arr, int n) {

        // Your code here
        // maxHere is max till i iteration.
        // maxSoFar is max for full array.
        // initially 0s.
        int maxHere = 0, maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // sum every element and store in maxHere.
            maxHere += arr[i];
            // if maxSoFar is less than maxHere, maxSoFar can have the value.
            if (maxSoFar < maxHere) {
                maxSoFar = maxHere;
            }
            // if maxHere is less than, make maxHere 0.
            if (maxHere < 0) {
                maxHere = 0;
            }
        }

        return maxSoFar;
    }
}
