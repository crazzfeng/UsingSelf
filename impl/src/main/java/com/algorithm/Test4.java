package com.algorithm;

/**
 * @author yufeng li
 * @title: Test4
 * @description:
 * @date 2019/8/21 15:14
 */
public class Test4 {
    public static void main(String[] args) {

        Test4 test4 = new Test4();
        String s = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        System.err.println(System.currentTimeMillis());
        String longestPalindrome = test4.longestPalindrome1("cbbd");
        System.err.println(System.currentTimeMillis());
        System.err.println(longestPalindrome.length() + "\n" + longestPalindrome);

    }

    public String longestPalindrome(String s) {

        String replace = s.replace("", "#");
        replace = '^' + replace + '$';
        int length = replace.length();
        String ans = "";
        for (int i = 1; i < length; i++) {
            String cs = "";
            for (int j = 1; j <= i; j++) {
                if (i + j >= length) {
                    continue;
                }
                if (replace.charAt(i - j) == replace.charAt(i + j)) {
                    cs = replace.substring(i - j, i + j + 1);
                    continue;
                }
                //i = i+j-1;
                break;
            }

            if (ans.length() < cs.length()) {
                ans = cs;
            }
        }

        return ans.replace("#", "");
    }


    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length == 0){
            return "";
        }
        String ans = s.charAt(0) + "";
        for (int i = 1; i < 2 * length - 1; i++) {
            String left = "";
            String right = "";
            String cs = "";
            int a = 1;
            for (int j = 1; j <= i && i + j <= 2 * length - 1; j++) {

                if ((i - j) % 2 != 1) {
                    left += s.charAt((i - j) / 2);
                    right += s.charAt((i + j) / 2);
                    if (!left.equals(right)) {
                        break;
                    }
                }
                cs = s.substring((i - j) / 2, (i + j+1) / 2-1);
                a = j;
            }
            //i = i + a -1;
            if (ans.length() < cs.length()) {
                ans = cs;
            }
        }

        return ans;
    }
}
