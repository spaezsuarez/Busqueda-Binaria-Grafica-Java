package algorithms;

public class QuickSort {

    public static void init(int i, int j, double a[]) {
        int tempi = i;
        int tempj = j;
        double x = a[(int)(i + j) / 2];
        do {
            while (a[i] < x) {
                i++;
            }
            while (x < a[j]) {
                j--;
            }
            if (i < j) {
                cambio(a, i, j);
                i = i + 1;
                j = j - 1;
            }
        } while (i < j);
        
        if (i == j) {
            if (x < a[i]) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        if (j - 1 == tempi) {
            if (a[tempi] > a[j]) {
                cambio(a, tempi, j);
            }
        } else {
            if (j > tempi) {
                init(tempi, j, a);
            }
        }
        if (i + 1 == tempj) {
            if (a[i] > a[tempj]) {
                cambio(a, i, tempj);
            }
        } else {
            if (i < tempj) {
                init(i, tempj, a);
            }
        }
    }// quicksort

    public static void cambio(double a[], int i, int j) {
        
        double t;
        t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
