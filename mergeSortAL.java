import java.util.ArrayList;

/**
 * @author Saahi Venkatraghavan
 */
public class mergeSortAL {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(64);
        arr.add(34);
        arr.add(25);
        arr.add(12);
        arr.add(22);
        arr.add(11);
        arr.add(90);

        int len = arr.size();

        if (len <= 1) {
            return;
        }

        int middleInd = len / 2;

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> merged = new ArrayList<>();

        // first half
        for (int i = 0; i < middleInd; i++) {
            first.add(arr.get(i));
        }

        // sort first half
        for (int i = 0; i < first.size() - 1; i++) {
            for(int j = i + 1; j < first.size(); j++) {
                if (first.get(i) > first.get(j)) {
                    int temp = first.get(i);
                    first.set(i, first.get(j));
                    first.set(j, temp);
                }
            }
        }

        System.out.println();

        // second half
        for (int i = middleInd; i < len; i++) {
            second.add(arr.get(i));
        }

        // sort second half
        for (int i = 0; i < second.size() - 1; i++) {
            for(int j = i + 1; j < second.size(); j++) {
                if (second.get(i) > second.get(j)) {
                    int temp = second.get(i);
                    second.set(i, second.get(j));
                    second.set(j, temp);
                }
            }
        }

        int firstInd = 0;
        int firstLen = first.size();
        int secondInd = 0;
        int secondLen = second.size();

        // merge the sorted halves
        while (firstInd < firstLen && secondInd < secondLen) {
            if (first.get(firstInd) <= second.get(secondInd)) {
                merged.add(first.get(firstInd));
                firstInd++;
            } else {
                merged.add(second.get(secondInd));
                secondInd++;
            }
        }

        // sdd remaining elements from first half
        while (firstInd < firstLen) {
            merged.add(first.get(firstInd));
            firstInd++;
        }

        // add remaining elements from second half
        while (secondInd < secondLen) {
            merged.add(second.get(secondInd));
            secondInd++;
        }

        for (int num : merged) {
            System.out.print(num + " ");
        }
    }
}
