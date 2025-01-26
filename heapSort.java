/**
 * @author Saahi Venkatraghavan
 */
public class heapSort {

    /*
      11
    /    \
   12     15
  /  \   /  \
 31  44 19  76
/  \
98   68

    */
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] insert(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = value;

        int currentIndex = arr.length;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (newArr[parentIndex] < newArr[currentIndex]) {
                swap(newArr, currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }

        return newArr;
    }

    public static void main(String[] args) {
        heapSort sorter = new heapSort();
        int[] heap = {11, 12, 15, 31, 44, 19, 76, 98, 68};

        // left child node: 2i + 1
        // right child node: 2i + 2
        // i - 1 / 2 = right parent
        // i - 2 / 2 = left parent

        // Insert a new value, say 50
        heap = sorter.insert(heap, 50);

        // Print the resulting heap
        for (int value : heap) {
            System.out.print(value + " ");
        }
    }
}
