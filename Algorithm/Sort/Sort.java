package Sort;

/**
 * 对数组arr进行排序
 *
 * @author Ozzy Yang
 * Finished Time:2019-11-30
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {25, 24, 12, 76, 98, 101, 90, 28, 56, 56, 4, 20, 465, 120, 845, 1, 6};
        Sort sort = new Sort();
        sort.bubbleSort(a);
        sort.printArray(a);
        sort.ranDomSort(a);
        sort.insertionSort(a);
        sort.printArray(a);
    }

    /**
     * 插入排序
     *
     * @param arr 需要排序的数组
     */
    public void insertionSort(int[] arr) {
        int cacheNum = 0;
        for (int i = 1; i < arr.length; i++) {
            cacheNum = arr[i];
            for (int j = i; j > 0; j--) {
                if (cacheNum < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = cacheNum;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 需要排序的数组
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int canum = 0;// 交换数值时的缓存变量
        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    canum = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = canum;
                }
            }
        }
    }

    /**
     * 打乱数组的顺序
     *
     * @param arr 需要打乱顺序的数组
     */
    public void ranDomSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int canum = 0;// 交换数值时的缓存变量
        for (int i = 0; i < arr.length - 1; i++) {
            double rand = Math.random() * (arr.length - 1);
            int j = (int) rand;
            canum = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = canum;
        }
    }

    /**
     * 遍历打印数组
     *
     * @param arr 要输出的数组
     */
    public void printArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int i = 0;
        for (int element : arr) {
            System.out.print("a[" + i + "]=" + element + " ");
            i++;
        }
        System.out.println();
    }
}
