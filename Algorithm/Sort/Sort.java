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
        selectionSort(a, "ASC");
        printArray(a);
    }

    /**
     * 插入排序
     *
     * @param arr 需要排序的数组
     */
    public static void insertionSort(int[] arr) {
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
    public static void bubbleSort(int[] arr) {
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
     * 按照指定的顺序对数组进行冒泡排序
     *
     * @param array     需要排序的数组
     * @param sortOrder ASC表示升序 DES表示降序
     */
    public static void bubbleSort(int[] array, String sortOrder) {
        int canum = 0;// 交换数值时的缓存变量
        // 冒泡排序
        if (sortOrder == "ASC") {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        canum = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = canum;
                    }
                }
            }
        } else if (sortOrder == "DES") {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        canum = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = canum;
                    }
                }
            }

        }
    }

    /**
     * 按照指定的顺序对数组进行选择排序
     *
     * @param array     需要排序的数组
     * @param sortOrder ASC表示升序 DES表示降序
     */
    public static void selectionSort(int[] array, String sortOrder) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (sortOrder.equals("ASC")) {
                    if (array[index] > array[j]) index = j;
                } else if (sortOrder.equals("DES")) {
                    if (array[index] < array[j]) index = j;
                } else {
                    System.out.println("sortOrder ERROR!");
                    return;
                }
            }
            if (index != i) {
                int cache = array[i];
                array[i] = array[index];
                array[index] = cache;
            }
        }
    }

    /**
     * 打乱数组的顺序
     *
     * @param arr 需要打乱顺序的数组
     */
    public static void randomSort(int[] arr) {
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
    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int i = 0;
        for (int element : arr) {
            System.out.print("a[" + i + "]=" + element + " ");
            i++;
        }
        System.out.println();
    }


    /**
     * 查找数组的最大值
     *
     * @param array 要查找的数组
     * @return 最大值
     */
    public static int arrayMaximun(int[] array) {
        int max = array[0];
        for (int element : array) {
            max = element > max ? element : max;
        }
        return max;
    }

    /**
     * 查找数组的最小值
     *
     * @param array 要查找的数组
     * @return 最小值
     */
    public static int arrayMinimun(int[] array) {
        int min = array[0];
        for (int element : array) {
            min = element < min ? element : min;
        }
        return min;
    }
}
