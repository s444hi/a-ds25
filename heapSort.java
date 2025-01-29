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

    public int[] removeMin(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        // find the minimum
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        int[] newArr = new int[arr.length - 1];

        // copy before
        for (int i = 0; i < minIndex; i++) {
            newArr[i] = arr[i];
        }

        // copy after
        for (int i = minIndex; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }

        if (minIndex < arr.length / 2) {
            int currentIndex = minIndex;

            while (true) {
                int leftChild = 2 * currentIndex + 1;
                int rightChild = 2 * currentIndex + 2;
                int largest = currentIndex;

                if (leftChild < newArr.length && newArr[leftChild] > newArr[largest]) {
                    largest = leftChild;
                }
                if (rightChild < newArr.length && newArr[rightChild] > newArr[largest]) {
                    largest = rightChild;
                }

                if (largest == currentIndex) {
                    break;
                }

                swap(newArr, currentIndex, largest);
                currentIndex = largest;
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

        heap = sorter.insert(heap, 50);

        System.out.println("after insertion:");
        for (int value : heap) {
            System.out.print(value + " ");
        }
        System.out.println();

        heap = sorter.removeMin(heap);

        System.out.println("after removing minimum:");
        for (int value : heap) {
            System.out.print(value + " ");
        }
    }
}