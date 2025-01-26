/**
 * @author Saahi Venkatraghavan
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int len = arr.length;

        if (len <= 1) {
            return;
        }

        int middleInd = len / 2;

        int[] first = new int[middleInd];
        int[] second = new int[len - middleInd];
        int[] merged = new int[len];

        // first half
        // 64, 34, 25
        for (int i = 0; i < middleInd; i++) {
            first[i] = arr[i];
            // System.out.println("FIRST HALF: " + first[i]);
        }

        /*
        64, 34, 25
        34, 64, 25

         */

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
        // 12, 22, 11, 90
        int j = 0;
        for (int i = middleInd; i < len; i++) {
            second[i - middleInd] = arr[i];
            // System.out.println("SECOND HALF: " + second[i - middleInd]);
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

        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }
    }
}
