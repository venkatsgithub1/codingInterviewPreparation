import java.util.*;

public class RearrangeAlternate {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        int[] arr3 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr4 = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        rearrange(arr, 6);
        rearrange(arr2, 11);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("----");
        Arrays.stream(arr2).forEach(System.out::println);
        System.out.println("****");
        rearrangeSpaceOptimized(arr3, 6);
        rearrangeSpaceOptimized(arr4, 11);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("----");
        Arrays.stream(arr2).forEach(System.out::println);
    }

    private static void rearrange(int[] arr, int n) {

        // Your code here
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n / 2; i++) {
            queue.add(arr[i]);
        }
        for (int i = n / 2; i < n; i++) {
            stack.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = stack.pop();
            } else {
                if (Objects.nonNull(queue.peek()))
                    arr[i] = queue.poll();
            }
        }
    }

    private static void rearrangeSpaceOptimized(int[] arr, int n) {
        int maxElement = arr[n - 1] + 1;
        int maxIndex = n - 1;
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= maxElement;
        }
    }
}
