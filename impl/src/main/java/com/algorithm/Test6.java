package com.algorithm;

/**
 * @author yufeng li
 * @title: Test6
 * @description:
 * @date 2019/10/29 17:56
 */
public class Test6 {
    public static void main(String[] args) {

        String s = "  0000000000012345678";
        System.err.println(myAtoi(s));
    }

    private static int myAtoi(String str) {
        String resString = "";
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            if ("".equals(resString) && !split[i].trim().equals("") && !split[i].matches("[0-9]|[-]|[+]")) {
                return 0;
            }
            if (!"".equals(resString) && !split[i].matches("[0-9]")) {
                break;
            }
            if (split[i].matches("[0-9]|[-]|[+]")) {
                resString += split[i];
            }
        }
        if (!"".equals(resString)) {
            char fc = resString.charAt(0);
            if (fc == '-' || fc == '+' || fc == '0') {
                int i=1;
                while ( i < resString.length()){
                    if (resString.charAt(i) != '0'){
                        break;
                    }
                    i++;
                }
                resString = fc + resString.substring(i);
            }
        }
        if ("-".equals(resString) || "+".equals(resString) || "".equals(resString)) {
            return 0;
        }
        if (resString.length() > 11){
            if (resString.charAt(0) == '-'){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        Long aLong = Long.valueOf(resString);
        if (aLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (aLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return aLong.intValue();
    }
}
