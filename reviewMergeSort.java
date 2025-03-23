/**
 * @author Saahi Venkatraghavan
 */
import java.util.Arrays;

public class reviewMergeSort {
    public static void mergeSort(int[] numArr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(numArr, left, middle);
            mergeSort(numArr, middle + 1, right);

            merge(numArr, left, middle, right);
        }
    }
    public static void merge(int[] numArr, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = numArr[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArr[j] = numArr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] < rightArr[j]) {
                numArr[k] = leftArr[i];
                i++;
            } else {
                numArr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            numArr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            numArr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int [] numArr = {6, 3, 9, 5, 2, 8, 7, 1, 4, 10};

        System.out.println("Original array: " + Arrays.toString(numArr));

        mergeSort(numArr, 0, numArr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(numArr));
    }
}
