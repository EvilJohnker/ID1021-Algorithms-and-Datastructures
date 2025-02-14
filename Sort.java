import java.util.Random;

public class Sort {

    public static void main(String[] args) {

        Random rnd = new Random();
        int[][][] arr = new int[12][100][];

        for (int n = 0; n < 12; n++) {
            int length = (int) (500 * Math.pow(2, n));
            for (int j = 0; j < 100; j++) {
                arr[n][j] = new int[length];
                for (int i = 0; i < length; i++) arr[n][j][i] = rnd.nextInt(length * 5);
            }
        }
            int[] jabadaba = new int[1];
            for (int i = 0; i < 10000000; i++) sort(jabadaba);

        for (int n = 0; n < 12; n++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < 12; j++){
                sort(arr[n][j]);
            }
            long t1 = System.nanoTime();
            System.out.println("Time taken:" + (t1-t0));
        }

    }

    static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int candidate = arr[i];
            int canindx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < candidate) {
                    candidate = arr[j];
                    canindx = j;
                }
            }
            swap(arr, i, canindx);
        }
    }
    static void InsertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j] ; j--) {
                swap(arr, j-1, j);
            }
        }
    }

    public static void sort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length -1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi)/2;
            sort(org, aux, lo, mid);
            sort(org, aux, mid + 1, hi);
            merge(org, aux, lo, mid, hi);
        }
    }
    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
// copy all items from lo to hi from org to aux
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
// let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
// for all indices from lo to hi
        for ( int k = lo; k <= hi; k++) {

            if (i > mid) {
                org[k] = aux[j];
                j++;
            }

            else if (j > hi) {
                org[k] = aux[i];
                i++;
            }

            else if (aux[i] <= aux[j]) {
                org[k] = aux[i];
                i++;
            }

            else {
                org[k] = aux[j];
                j++;
            }
        }
    }

    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
