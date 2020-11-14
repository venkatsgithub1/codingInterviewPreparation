package twoPointers;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInSortedArrays {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 6, 7, 9};
        int[] b = new int[]{1, 2, 4, 5, 9, 10};

        // 1, 4, 9
        System.out.println(commonElements(a, b));

        int[] c = new int[]{1, 2, 9, 10, 11, 12};
        int[] d = new int[]{0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};

        // 1, 2, 9, 10, 12
        System.out.println(commonElements(c, d));

        int[] e = new int[]{0, 1, 2, 3, 4, 5};
        int[] f = new int[]{6, 7, 8, 9, 10, 11};

        // blank array
        System.out.println(commonElements(e, f));
    }

    private static List<Integer> commonElements(int[] a, int[] b) {
        int x = 0, y = 0;
        List<Integer> result = new ArrayList<>();

        // two pointers, use two pointers as starts
        // every time check if data at both pointers
        // are equal, else increment smaller data pointer
        while (x < a.length && y < b.length) {
            if (a[x] == b[y]) {
                result.add(a[x]);
                x++;
                y++;
            } else if (a[x] < b[y]) {
                x++;
            } else {
                y++;
            }
        }

        return result;
    }
}
