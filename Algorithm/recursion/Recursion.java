package recursion;

public class Recursion {
    public static void main(String[] args) {
        recPrintNum(10000);
    }

    /**
     * 递归地按位打印整数
     *
     * @param num 需要打印的整数
     */
    public static void recPrintNum(int num) {
        if (num >= 10) {
            recPrintNum(num / 10);
        }
        System.out.print(num % 10);
    }
}
