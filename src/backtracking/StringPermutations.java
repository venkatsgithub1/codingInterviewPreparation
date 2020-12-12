package backtracking;

public class StringPermutations {
    public static void main(String[] args) {
        permutate("ABC", 0, 2);
    }

    private static void permutate(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permutate(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String str, int j, int k) {
        char[] ch = str.toCharArray();
        char temp = ch[j];
        ch[j] = ch[k];
        ch[k] = temp;
        return String.valueOf(ch);
    }
}
