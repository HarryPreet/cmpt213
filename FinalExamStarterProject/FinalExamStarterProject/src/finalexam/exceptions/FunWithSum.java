package finalexam.exceptions;

/**
 * Sum up numbers in an array
 */
public class FunWithSum {
    private static final int INVALID_LENGTH = -1;
    private static final int INVALID_VALUE = -2;

    static int sumUpPositiveArray(int data[]) {
        if (data.length == 0) {
            return INVALID_LENGTH;
        }
        int sum = 0;
        for (int value : data) {
            if (value < 0) {
                return INVALID_VALUE;
            }
            sum += value;
        }
        return sum;
    }

    static void testSumUpPositiveArray(String description, int[] data) {
        int sum = sumUpPositiveArray(data);
        if (sum == INVALID_LENGTH) {
            System.out.println(description + ": Invalid length; must be 0 or more elements.");
        } else if (sum == INVALID_VALUE) {
            System.out.println(description + ": Invalid array value; all elements must be non-negative.");
        } else {
            System.out.println(description + ": Sum is " + sum);
        }
    }

    public static void main(String[] args) {
        testSumUpPositiveArray("3 positives", new int[]{1, 2, 3});
        testSumUpPositiveArray("1 positive ", new int[]{10});
        testSumUpPositiveArray("Empty array", new int[]{});
        testSumUpPositiveArray("A negative ", new int[]{1, -12, 3});
        System.out.println("Done all tests.");
    }
}
