package arrays;

import java.util.HashMap;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 3, 7, 5};
        int req = 12;
        subarraySum(arr, req);
        subarraySumSolution2(arr, req);
    }

    private static void subarraySumSolution2(int[] arr, int req) {
        // map to store which sum appeared at which index.
        HashMap<Integer, Integer> map = new HashMap<>();

        int currentSum = 0;
        int start = 0;
        int end = -1;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum - req == 0) {
                end = i;
                break;
            }

            if (map.containsKey(currentSum - req)) {
                start = map.get(currentSum - req) + 1;
                end = i;
                break;
            }

            map.put(currentSum, i);
        }
        System.out.println(start + " " + end);
    }

    private static void subarraySum(int[] arr, int req) {
        int n = arr.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            if (arr[i] == req) {
                start = i;
                end = i;
                found = true;
                break;
            } else if (sum + arr[i] == req) {
                end = i;
                found = true;
                break;
            } else if (sum + arr[i] < req) {
                sum += arr[i];
            } else {
                int tempSum = sum + arr[i];
                while (tempSum >= req && start <= i) {
                    if (tempSum == req) {
                        end = i;
                        found = true;
                        break;
                    }
                    tempSum -= arr[start];
                    sum = tempSum;
                    start++;
                }
            }
        }
        System.out.println(start + " " + end + " " + found);
    }
}
