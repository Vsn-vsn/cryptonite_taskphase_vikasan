import java.util.Scanner;

class Mixer {
    private int[] arr;

    // Method to accept the elements of the array in ascending order without any duplicates
    public void accept() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        arr = new int[n];

        System.out.println("Enter the elements in ascending order (no duplicates):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Ensure the input array is sorted and has no duplicates
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                System.out.println("Array must be in ascending order and have no duplicates.");
                System.exit(0);
            }
        }
    }

    // Method to merge the current object array elements with the parameterized array elements
    public Mixer mix(Mixer A) {
        int[] array1 = arr;
        int[] array2 = A.arr;
        int[] mergedArray = new int[array1.length + array2.length];

        int i = 0, j = 0, k = 0;

        // Merge the two sorted arrays
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                mergedArray[k++] = array1[i++];
            } else if (array1[i] > array2[j]) {
                mergedArray[k++] = array2[j++];
            } else {
                // Skip duplicates
                mergedArray[k++] = array1[i++];
                j++;
            }
        }
        //copying remaining ele's
        while (i < array1.length) {
            mergedArray[k++] = array1[i++];
        }

        while (j < array2.length) {
            mergedArray[k++] = array2[j++];
        }

        // Create a new Mixer object for the merged array
        Mixer result = new Mixer();
        result.arr = new int[k];
        System.arraycopy(mergedArray, 0, result.arr, 0, k);

        return result;
    }

    // Method to display the elements of the array
    public void display() {

        System.out.print("Array elements: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Getter method for the array
    public int[] getArray() {
        return arr;
    }
}
public class Demo {
    public static void main(String[] args) {
        Mixer mixer1 = new Mixer();
        Mixer mixer2 = new Mixer();

        System.out.println("Enter details for the first array:");
        mixer1.accept();

        System.out.println("Enter details for the second array:");
        mixer2.accept();

        // Merge the two mixers
        Mixer mergedMixer = mixer1.mix(mixer2);

        // Display the result
        System.out.println("Merged Array:");
        mergedMixer.display();
    }
}
