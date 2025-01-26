import java.util.Scanner;

/**
 * @author Saahi Venkatraghavan
 */
public class mergeSortInput {
    public static void main(String[] args) {
        System.out.println("Enter 7 numbers: ");

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[7];

        // Get input for all 7 numbers
        for (int i = 0; i < 7; i++) {
            arr[i] = scanner.nextInt();
        }

        int len = arr.length;

        if (len <= 1) {
            return;
        }

        int middleInd = len / 2;

        int[] first = new int[middleInd];
        int[] second = new int[len - middleInd];
        int[] merged = new int[len];

        // first half
        for (int i = 0; i < middleInd; i++) {
            first[i] = arr[i];
        }

        for (int i = 0; i < first.length - 1; i++) {
            for(int j = i + 1; j < first.length; j++) {
                if (first[i] > first[j]) {
                    int temp = first[i];
                    first[i] = first[j];
                    first[j] = temp;
                }
            }
        }

        System.out.println();

        // second half
        int j = 0;
        for (int i = middleInd; i < len; i++) {
            second[i - middleInd] = arr[i];
        }

        for (int l = 0; l < second.length - 1; l++) {
            for(int m = l + 1; m < second.length; m++) {
                if (second[l] > second[m]) {
                    int temp = second[l];
                    second[l] = second[m];
                    second[m] = temp;
                }
            }
        }

        int firstInd = 0;
        int firstLen = first.length;
        int secondInd = 0;
        int secondLen = second.length;

        int mergedInd = 0;

        // AFTER EACH HALF IS SORTED
        while (firstInd < firstLen && secondInd < secondLen) {
            if (first[firstInd] <= second[secondInd]) {
                merged[mergedInd] = first[firstInd];
                firstInd++;
                mergedInd++;
            } else {
                merged[mergedInd] = second[secondInd];
                secondInd++;
                mergedInd++;
            }
        }

        while (firstInd < firstLen) {
            merged[mergedInd] = first[firstInd];
            firstInd++;
            mergedInd++;
        }

        while (secondInd < secondLen) {
            merged[mergedInd] = second[secondInd];
            secondInd++;
            mergedInd++;
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }

        scanner.close();
    }
}
