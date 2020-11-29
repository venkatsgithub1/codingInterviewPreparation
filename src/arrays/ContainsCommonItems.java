package arrays;

import java.util.HashSet;

public class ContainsCommonItems {
    public static void main(String[] args) {
        char[] arr1 = new char[]{'a', 'b', 'c', 'x'};
        char[] arr2 = new char[]{'m', 'n', 'x'};

        System.out.println(containsCommonItems(arr1, arr2));
    }

    private static boolean containsCommonItems(char[] arr1, char[] arr2) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : arr1) {
            set.add(ch);
        }

        for (char ch2 : arr2) {
            if (set.contains(ch2)) {
                return true;
            }
        }

        return false;
    }
}
