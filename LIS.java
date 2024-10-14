import java.util.*;

class LIS {

    static int lisEndAt(int[] array, int index) {
        if (index == 0)
            return 1;

        int maxLength = 1;
        for (int prev = 0; prev < index; prev++) {
            if (array[prev] < array[index]) {
                maxLength = Math.max(maxLength, lisEndAt(array, prev) + 1);
            }
        }
        return maxLength;
    }

    static int calculateLIS(int[] array) {
        int length = array.length;
        int result = 1;
        for (int i = 1; i < length; i++) {
            result = Math.max(result, lisEndAt(array, i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of LIS is " + calculateLIS(array));
    }
}
