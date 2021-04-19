package sort;

import recursion.Recursion;


/**
 * 对数组arr进行排序
 *
 * @author Ozzy Yang
 * Finished Time:2019-11-30
 */
public class Sort {
    public static void main(String[] args) {
        Recursion.recPrintNum(1326);
        int[] a = {25, 24, 12, 76, 98, 90, 28, 56, 56, 4};
        //quickSort(a);
        //printArray(a);
    }


    /**
     * 插入排序
     *
     * @param arr 需要排序的数组
     */
    public static void insertionSort(int[] arr) {
        if (isNullOrEmpty(arr)) return;
        for (int i = 1; i < arr.length; i++) {
            int cacheNum = arr[i];
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
        if (isNullOrEmpty(arr)) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int cacheNum = arr[j];//交换数值的缓存变量
                    arr[j] = arr[j + 1];
                    arr[j + 1] = cacheNum;
                }
            }
        }
    }

    public static void mergeSort(int[] array) {
        int[] tmpArray = new int[array.length];

    }

    private static void mergeSort(int[] array, int[] tmpArray, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int centralIndex = (leftIndex + rightIndex) / 2;
            mergeSort(array, tmpArray, leftIndex, centralIndex);
            mergeSort(array, tmpArray, centralIndex + 1, rightIndex);
            mergeArray(array, tmpArray, leftIndex, centralIndex + 1, rightIndex);
        }
    }

    private static void mergeArray(int[] array, int[] tmpArray, int leftIndex, int rightIndex, int rightEnd) {
        int leftEnd = rightIndex - 1;
        int tmpIndex = leftIndex;
        int numElements=rightEnd-leftIndex+1;
        while (leftIndex<=leftEnd){

        }
    }

    public static void quickSort(int[] arr) {
        if (isNullOrEmpty(arr)) return;
        int marginValue = quickSortStep(arr, 0, arr.length - 1);
        while (marginValue != (arr.length - 1) / 2) {
            marginValue = quickSortStep(arr, 0, arr.length - 1);
        }

    }

    public static int quickSortStep(int[] arr, int startIndex, int endIndex) {
        int cacheNum = arr[startIndex];
        int loopCount = 1;
        while (startIndex < endIndex) {
            if (loopCount % 2 == 1) {
                for (int i = endIndex; i > startIndex; i--) {
                    if (arr[i] < cacheNum) {
                        arr[startIndex++] = arr[i];
                        endIndex = i;
                        break;
                    } else {
                        endIndex = startIndex;
                    }
                }

            } else {
                for (int i = startIndex; i < endIndex; i++) {
                    if (arr[i] > cacheNum) {
                        arr[endIndex--] = arr[i];
                        startIndex = i;
                        break;
                    } else {
                        startIndex = endIndex;
                    }
                }
            }
            loopCount++;
        }
        arr[startIndex] = cacheNum;
        return startIndex;
    }

    /**
     * 按照指定的顺序对数组进行冒泡排序
     *
     * @param array     需要排序的数组
     * @param sortOrder ASC表示升序 DES表示降序
     */
    public static void bubbleSort(int[] array, String sortOrder) {
        if (isNullOrEmpty(array)) return;
        if (!(sortOrder.equals("ASC") || sortOrder.equals("DES"))) {
            System.out.println("SortOrder ERROR!");
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if ((sortOrder.equals("ASC") && array[j] > array[j + 1]) || (sortOrder.equals("DES") && array[j] < array[j + 1])) {
                    int cacheNum = array[j];// 交换数值时的缓存变量
                    array[j] = array[j + 1];
                    array[j + 1] = cacheNum;
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
        if (isNullOrEmpty(array)) return;
        if (!(sortOrder.equals("ASC") || sortOrder.equals("DES"))) {
            System.out.println("SortOrder Error!");
        }
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (sortOrder.equals("ASC") && array[index] > array[j]) {
                    index = j;
                } else if (sortOrder.equals("DES") && array[index] < array[j]) {
                    index = j;
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
        if (isNullOrEmpty(arr)) return;
        for (int i = 0; i < arr.length - 1; i++) {
            double rand = Math.random() * (arr.length - 1);
            int j = (int) rand;
            int cacheNum = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = cacheNum;
        }
    }

    /**
     * 遍历打印数组
     *
     * @param arr 要遍历的数组
     */
    public static void printArray(int[] arr) {
        if (isNullOrEmpty(arr)) {
            System.out.println("array's size is 0!");
            return;
        }
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
    public static int arrayMax(int[] array) {
        if (isNullOrEmpty(array)) {
            System.out.println("array's size is 0!");
            return -1;
        }
        int max = array[0];
        for (int element : array) {
            max = Math.max(element, max);
        }
        return max;
    }

    /**
     * 查找数组的最小值
     *
     * @param array 要查找的数组
     * @return 最小值
     */
    public static int arrayMin(int[] array) {
        if (isNullOrEmpty(array)) {
            System.out.println("array's size is 0!");
            return -1;
        }
        int min = array[0];
        for (int element : array) {
            min = Math.min(element, min);
        }
        return min;
    }

    /**
     * 对要排序的数组进行边界值的判断
     *
     * @param arr 要判断的数组
     * @return 数组为空或者只有1个以下的元素，则返回true，否则返回false
     */
    private static boolean isNullOrEmpty(int[] arr) {
        return arr == null || arr.length == 1;
    }
}