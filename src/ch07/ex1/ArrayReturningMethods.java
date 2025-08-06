package ch07.ex1;

public class ArrayReturningMethods {
    public static int[] range(int start, int end) {
        if (start > end) {
            return new int[0];
        }
        int[] result = new int[end - start + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = start + i;
        }
        return result;
    }

    public static int[] filterPositive(int[] input) {
        int count = 0;
        for (int num : input) {
            if (num > 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : input) {
            if (num > 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    public static int[] reverse(int[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[input.length - 1 - i];
        }
        return result;
    }


    public static void main(String[] args) {
        // range 테스트
        int[] numbers = range(5, 10);
        System.out.print("range(5, 10): ");
        printArray(numbers);

        // filterPositive 테스트
        int[] mixed = {-3, 5, 0, -7, 12, -1, 8};
        int[] positive = filterPositive(mixed);
        System.out.print("\n양수만: ");
        printArray(positive);

        // merge 테스트
        int[] first = {1, 3, 5};
        int[] second = {2, 4, 6};
        int[] merged = merge(first, second);
        System.out.print("\n병합: ");
        printArray(merged);

        // reverse 테스트
        int[] original = {1, 2, 3, 4, 5};
        int[] reversed = reverse(original);
        System.out.print("\n뒤집기: ");
        printArray(reversed);
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}