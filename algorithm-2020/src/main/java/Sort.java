import java.util.Arrays;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 16:28 2020/6/14
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Sort {

    public static void main(String args[]) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 100, 123, 124, 125, 234, 345, 456, 789, 90000);
//        Integer[] a = list.toArray(new Integer[0]);
//
//        binarySearch(a, 213);
//        binarySearch2(a, 0, a.length - 1, 345);
        int[] a = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//        bubbleSort(a);
//        chooseSort(a);
        quickSort(a, 0, a.length - 1);
        Arrays.stream(a, 0, a.length).forEach(o -> System.out.print(o + ","));

    }

    //快速排序 n*logn
    public static void quickSort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        if (i >= j) {
            return;
        }
        int key = a[i];
        while (i < j) {
            while (a[j] > key && j > i) {
                j--;
            }
            a[i] = a[j];

            while (a[i] < key && j > i) {
                i++;
            }
            a[j] = a[i];
        }
        //i j 相遇
        a[j] = key;
        quickSort(a, low, j - 1);
        quickSort(a, j + 1, high);
    }

    // 选择排序 n*n
    public static void chooseSort(int a[]) {
        int len = a.length;
        int min_index;
        for (int i = 0; i < len; i++) {
            min_index = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            int temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }

    }

    // 冒泡排序 复杂度n*n
    public static void bubbleSort(int a[]) {
        int len = a.length;
        boolean isChange = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] ^ a[j + 1];// 00000011
                    a[j + 1] = a[j] ^ a[j + 1];// 00000001
                    a[j] = a[j] ^ a[j + 1];// 00000010
                    isChange = true;
                }
            }
            if (!isChange) {
                System.out.println("not change");
                break;
            }
        }
    }


    /**
     * 二分查询
     *
     * @param a
     * @param f
     */
    public static void binarySearch(Integer a[], int f) {
        int n = 0;
        int start = 0;
        int end = a.length - 1;
        int mid = 0;
        while (start <= end) {
            n++;
            mid = (start + end) / 2;
            if (a[mid] == f) {
                System.out.println("start place:" + mid + ",find f:" + f + ",time:" + n);
                break;
            }
            if (f < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    /**
     * 二分查询递归
     *
     * @param a
     * @param start
     * @param end
     * @param f
     * @return
     */
    public static boolean binarySearch2(Integer a[], int start, int end, int f) {
        int mid = (start + end) / 2;
        if (f < a[start] || f > a[end] || a[start] > a[end]) {
            System.out.println("not found:" + mid);
            return false;

        }
        if (f > a[mid]) {
            return binarySearch2(a, mid + 1, end, f);
        } else if (f < a[mid]) {
            return binarySearch2(a, start, mid - 1, f);
        } else {
            System.out.println("found:" + mid);
            return true;
        }
    }


}
