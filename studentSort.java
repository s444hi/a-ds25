/**
 * @author Saahi Venkatraghavan
 */
public class studentSort {

    /*
    Problem: Merging Sorted Student Lists
You are given two sorted lists of student IDs (integers) from two different classes. Your task is to merge these two lists into a single sorted list using Merge Sort.

Input:
Two arrays, classA and classB, containing student IDs sorted in ascending order.

Output:
A single sorted array containing all student IDs from both classes.

Example:
java
Copy
Edit
Input:
classA = [101, 105, 150, 200]
classB = [102, 108, 130, 180, 220]

Output:
[101, 102, 105, 108, 130, 150, 180, 200, 220]
Requirements:
Implement Merge Sort to merge the two lists.

Do not use built-in sorting functions (like Arrays.sort()).
     */
    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);

        }
        return arr;
    }

    public static void merge(int[] numArr, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArr[i] = numArr[left + i];
        }

        for (int j = 0; j < rightLength; j++) {
            rightArr[j] = numArr[middle + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftLength && j < rightLength) {
            if (leftArr[i] < rightArr[j]) {
                numArr[k] = leftArr[i];
                i++;
            } else {
                numArr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            numArr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            numArr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] classA = {101, 105, 150, 200};

        int[] mergedList = mergeSort(classA, 0, classA.length);

        System.out.print("Merged List: ");
        for (int num : mergedList) {
            System.out.print(num + " ");
        }
    }

}
