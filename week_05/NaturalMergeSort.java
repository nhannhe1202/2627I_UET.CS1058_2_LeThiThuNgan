import java.util.Scanner;
import java.util.Arrays;

public class NaturalMergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        naturalMergeSort(arr);
        System.out.println(Arrays.toString(arr));

        scanner.close();
    }

    public static void naturalMergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        boolean isSorted = false;
        int pass = 1;

        while (!isSorted) {
            isSorted = true;
            int left = 0;
            boolean mergedInThisPass = false;
            printCurrentRuns(arr);

            while (left < n) {
                int mid = left;
                while (mid < n - 1 && arr[mid] <= arr[mid + 1]) {
                    mid++;
                }

                if (mid == n - 1) {
                    break;
                }

                int right = mid + 1;
                while (right < n - 1 && arr[right] <= arr[right + 1]) {
                    right++;
                }

                merge(arr, left, mid, right);
                mergedInThisPass = true;
                isSorted = false;

                left = right + 1;
            }
            if (mergedInThisPass) {
                System.out.printf("KẾT QUẢ BƯỚC %d (Sau lượt quét %d): %s\n", pass, pass, Arrays.toString(arr));
                pass++;
            } else {
                isSorted = true;
            }
        }
    }

    // Hàm phụ trợ để quét và in ra các Run hiện tại dưới dạng trực quan
    private static void printCurrentRuns(int[] arr) {
        System.out.print("Các đoạn tăng (Runs) hiện tại: ");
        int i = 0;
        while (i < arr.length) {
            System.out.print("[");
            System.out.print(arr[i]);
            while (i < arr.length - 1 && arr[i] <= arr[i + 1]) {
                i++;
                System.out.print(", " + arr[i]);
            }
            System.out.print("] ");
            i++;
        }
        System.out.println();
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
