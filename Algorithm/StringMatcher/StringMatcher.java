package StringMatcher;

import java.util.*;


/**
 * 用于匹配指定字符串s中是否包含某个特定文本模式p
 *
 * @author Ozzy Yang
 * Finshed Time:2021-04-15
 */
public class StringMatcher {
    public static final int TEST_CASES = 10000;//匹配结果为正确以及错误的测试用例的数量
    public static final int S_LENGTH_MAX = 10000;//每个字符串s长度的最大值

    /**
     * 生成测试用例，并计算算法的运行时间然后输出结果
     */
    public static void main(String[] args) {
        StringMatcher sm = new StringMatcher();
        List<String> ss = new ArrayList<>();
        List<String> ps = new ArrayList<>();

        //生成测试用例，ss[i]为被匹配的字符串，ps[i]为需要匹配的字符串
        for (int i = 0; i < TEST_CASES; i++) {
            StringBuilder sTrue = new StringBuilder();
            StringBuilder sFalse = new StringBuilder();
            StringBuilder pFalse = new StringBuilder();

            //随机生成一k长度的字符串ss[i]和ps[i]
            int k = (int) (S_LENGTH_MAX * Math.random());
            for (; k >= 0; k--) {
                sTrue.append((char) (48 + 9 * Math.random()));
                sFalse.append((char) (65 + 26 * Math.random()));
                //匹配结果为错误的字符串长度只有k的一半
                if (k >= (k / 2)) {
                    pFalse.append((char) (65 + 26 * Math.random()));
                }
            }
            String sTrues = sTrue.toString();
            int beginIndex = (int) (sTrues.length() / 2 * Math.random());
            ss.add(sTrues);
            //匹配结果为正确的
            ps.add(sTrues.substring(beginIndex, beginIndex + sTrues.length() / 2));
            ss.add(sFalse.toString());
            ps.add(pFalse.toString());
        }

        int trueNum = 0, falseNum = 0;
        long start = System.currentTimeMillis();
        /*for (int i = 0; i < ss.size(); i++) {
            if (sm.ViolentMatch(ss.get(i), ps.get(i))) {
                trueNum++;
            } else {
                falseNum++;
            }
        }*/
        long end = System.currentTimeMillis();
        System.out.printf("Costs:%dms,%d true,%d false\n", (end - start), trueNum, falseNum);
        trueNum = falseNum = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < ss.size(); i++) {
            if (sm.KMPMatch(ss.get(i), ps.get(i))) {
                trueNum++;
            } else {
                falseNum++;
            }
        }
        end = System.currentTimeMillis();
        System.out.printf("Costs:%dms,%d true,%d false\n", (end - start), trueNum, falseNum);
        for (int i = 0; i < ss.size(); i++) {
            if (sm.KMPMatch(ss.get(i), ps.get(i)) != sm.ViolentMatch(ss.get(i), ps.get(i))) {
                System.out.println("出错字符串--S:" + ss.get(i) + " P:" + ps.get(i));
                System.out.println(sm.KMPMatch(ss.get(i), ps.get(i)) + " " + sm.ViolentMatch(ss.get(i), ps.get(i)));
            }
        }
    }

    /**
     * 暴力匹配
     *
     * @param s 被匹配的字符串
     * @param p 需要匹配的模式串
     * @return 包含则返回true，不包含则返回false
     */
    public boolean ViolentMatch(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()) return false;
        if (s.length() == p.length()) return s.equals(p);
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (k == p.length()) return true;
                if (s.charAt(j) == p.charAt(k)) {
                    k++;
                } else {
                    k = 0;
                }
            }
        }
        return false;
    }


    /**
     * 使用KMP算法进行匹配
     *
     * @param s 被匹配的字符串
     * @param p 需要匹配的字符串
     * @return 包含则返回true，不包含则返回false
     */
    public boolean KMPMatch(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()) return false;
        if (s.length() == p.length()) return s.equals(p);
        int i = 0, k = 0;
        while (i != s.length()) {
            if (k == p.length()) return true;
            if (s.charAt(i) == p.charAt(k)) {
                i++;
                k++;
            } else {
                if (k == 0) {
                    i++;
                    continue;
                }
                //如果匹配未完成，则根据KMP算法项后移动继续匹配
                i = i - k + nextI(p.substring(0, k - 1));
                k = 0;
            }
        }
        return false;
    }

    /**
     * 查找字符串中相等的最长前后缀，返回相等第一个后缀的首字母的下标
     *
     * @param s 已经匹配好的字符串
     * @return 相等后缀的首字母的下标
     */
    private int nextI(String s) {
        int k = s.length() - 1;
        while (k >= 1) {
            for (int j = 1; j <= s.length() - k; j++) {
                if (s.substring(0, k).equals(s.substring(j, j + k))) return j;
            }
            k--;
        }
        //查不到则往后移动一位
        return 1;
    }
}
