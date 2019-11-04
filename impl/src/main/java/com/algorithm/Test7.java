package com.algorithm;

/**
 * @author yufeng li
 * @title: Test7
 * @description:
 * @date 2019/10/30 16:19
 */
public class Test7 {
    public static void main(String[] args) {
       /* int x = 13531;
        System.err.println(isPalindrome(x));*/
        String s = "kjjbaa";
        String p = "k.*k";
        System.err.println(isMatch(s, p));
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        //得到该数有多少位
        int y = x;
        int w = 1;
        while (y >= 10) {
            y = y / 10;
            w++;
        }
        //从头尾开始比较
        int i = 1;
        while (i < w / 2 + 1) {
            int m = ((Double) Math.pow(10, i)).intValue();
            int a = (x % m) / (m / 10);
            int n = ((Double) Math.pow(10, w - i)).intValue();
            int b = (x / n) % 10;
            if (a != b) {
                return false;
            }
            i++;
        }
        return true;

    }


    /**
     * . 匹配任意单个字符  *匹配0个或多个前一字符
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        //s,p相同
        if (s.equals(p)) {
            return true;
        }
        String[] split = p.split("\\*");
        for (int i = 0; i < split.length; i++) {
            String reg = split[i];
            if (s.equals("")){
                if (!reg.equals(".")){
                    return false;
                }
                continue;
            }
            int a = reg.length() - 1;
            int j = 0;
            while (j <= a) {
                if (reg.charAt(j) != s.charAt(j) && reg.charAt(j) != '.') {
                    return false;
                }
                j++;
            }

            while (j < s.length()) {
                if (i != split.length - 1 || p.charAt(p.length() - 1) == '*') {
                    if (s.charAt(j) != reg.charAt(a) && reg.charAt(a) != '.') {
                        break;
                    }
                } else {
                    if (s.charAt(j) != reg.charAt(a) && reg.charAt(a) != '.') {
                        return false;
                    }
                    break;
                }
                j++;
            }
            s = s.substring(j);
        }
        if (s.length() > 0) {
            return false;
        }
        return true;
    }
}
