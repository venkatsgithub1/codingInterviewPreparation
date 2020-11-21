package algorithms.hackerrank;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
    }

    private static int countingValleys(int steps, String path) {
        // pos variable is for position tracking.
        // val variable is for no. of valleys.
        int pos = 0, val = 0;
        // a character with initial value N means not a valley.
        char ch = 'N';

        // iterate over all steps.
        for (int i = 0; i < steps; i++) {
            // if step is U and position is above sea level, a mountain, update character to Mountain.
            if (path.charAt(i) == 'U') {
                pos++;
                if (pos > 0)
                    ch = 'M';
            } else {
                // downhill, reduce position.
                pos--;
            }

            // if character holds mountain and position is 0, that means mountain descent.
            if (ch == 'M' && pos == 0) {
                ch = 'N';
            } else if (pos == 0) {
                // if not mountain and position is sea level, valley, increase counter.
                val++;
            }
        }
        // return count.
        return val;
    }
}
