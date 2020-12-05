package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class CountTriplets {

    // difference between permutations and combinations.
    // https://byjus.com/maths/difference-between-permutation-and-combination/#:~:text=Difference%20between%20Permutation%20and%20Combination%20%20%20,a%20single%20...%20%201%20more%20rows%20

    public static void main(String[] args) {
        System.out.println(countTriplet(new int[]{1, 2, 3, 4, 5}));
    }

    private static int countTriplet(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int k : arr) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        // sort array
        Arrays.sort(arr);
        // get maximum value
        int maxVal = arr[arr.length - 1];

        // Your code goes here
        int result = 0;
        // f(0)c3,how many combinations of zeroes possible.
        if (map.containsKey(0)) {
            result += map.get(0) * (map.get(0) - 1) * (map.get(0) - 2) / 6;
        }

        for (int i = 1; i <= maxVal; i++) {

            int onex = map.getOrDefault(i, 0);
            int twox = map.getOrDefault(2 * i, 0);
            // f(0) * f(x)c2 0+x=x
            result += (map.get(0) * (onex * (onex - 1) / 2));
            // x+x=2x f(x)*f(x)-1/2*f(2x)
            result += (onex * ((onex - 1) / 2) * twox);

            for (int j = i + 1; j <= maxVal; j++) {
                // x,y,x+y, f(x).f(y).f(x+y)
                result += (map.getOrDefault(i, 0)
                        * map.getOrDefault(j, 0)
                        * map.getOrDefault(i + j, 0));
            }
        }
        return result;
    }
}
