package algorithms.hackerrank;

public class JumpingOnClouds {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
    }

    private static int jumpingOnClouds(int[] c) {

        int i = 0, jumps = 0;

        // loop till index variable is less than steps length.
        while (i < c.length) {
            // if step is 0, jump.
            if (c[i] == 0) {
                // jump from here 2 steps.
                if (i + 2 < c.length && c[i + 2] == 0) {
                    // if the step value is present and 0, increment i=i+2, jumps.
                    i += 2;
                    jumps++;
                } else if (i + 1 < c.length && c[i + 1] == 0) {
                    // if the step value is present and 0, increment i, jumps.
                    jumps++;
                    i++;
                } else {
                    // if no 0 step found increment to next step.
                    i++;
                }
            } else {
                i++;
            }
        }
        return jumps;
    }
}
