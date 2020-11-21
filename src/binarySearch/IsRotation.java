package binarySearch;

public class IsRotation {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] b = new int[]{4, 5, 6, 7, 1, 2, 3};

        System.out.println(compare(a, b));
    }

    private static boolean compare(int[] a, int[] b) {

        // if arrays length is not same can't rotate
        if (a.length != b.length) return false;

        // find starting point in the rotated array
        // compare function checks
        // for data equality.
        int start;
        if (a[0] > a[a.length - 1]) {
            start = binarySearchStart(a);
            System.out.println("here 1");
            return compare(a, b, start);
        } else {
            start = binarySearchStart(b);
            System.out.println("here 2");
            return compare(b, a, start);
        }
    }

    private static boolean compare(int[] a, int[] b, int start) {
        for (int i = start, j = 0; i < a.length && j < start; i++, j++) {
            if (a[i] != b[j]) {
                return false;
            }
        }

        for (int i = 0, j = start - 1; i < start && j < a.length; i++, j++) {
            if (a[i] != b[j]) {
                return false;
            }
        }
        return true;
    }

    private static int binarySearchStart(int[] a) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);

            // if left data<=right already ascending.
            if (a[left] <= a[right]) {
                return left;
            }

            // next and prev values module n
            int next = (mid + 1) % a.length;
            int prev = (mid + a.length - 1) % a.length;

            // if mid value is less than both next
            // and prev, then it is start.
            if (a[mid] <= a[next] && a[mid] <= a[prev]) {
                return mid;
            }

            // if mid <= right,
            // start can be before mid.
            if (a[mid] <= a[right]) {
                right = mid - 1;
            }

            // if mid >= left,
            // start can be after mid.
            if (a[mid] >= a[left]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
