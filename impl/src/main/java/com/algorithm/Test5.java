package com.algorithm;

import org.apache.commons.lang.StringUtils;

/**
 * @author yufeng li
 * @title: Test5
 * @description:
 * @date 2019/10/29 10:34
 */
public class Test5 {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        String s = "jrqopubjguxhxdipfzwswybgfylqvjzharvrlyauuzdrcnjkphclffrkeecbpdipufhidjcxjhrnxcxmjcxohqanxdrmgzebhnlmwpmhwdvthsfqueeexgrujigskmvrzgfwvrftwapdtutpbztygnsrxajjngcomikjzsdwssznovdruypcnjulkfuzmxnafamespckjcazxdrtdgyrqscczybnvqqcqcjitlvcnvbmasidzgwraatzzwpwmfbfjkncvkelhhzjchpdnlunmppnlgjznkewwuysgefonexpmmsbaopmdgzqmkqzxuvtqvnxbslqzkglzamzpdnsjolvybwxxttqognrbaiakqllszkhfzconnmoqklpeefsnsmouwqhodsgcfohesyshmgxwtoayuvnojdjftqtwkbapriujimqwspslgvlcsaqbdbgwtbseettwdnfnbyjvpdjxyuzqxstatbzpctthoofremgfkrbcvkzvgbofthgojhdnaywpnbitoraaibednezwfpdawlohssvtqtkfvsylj70";
        String convert = convert(s, 3);
        long l1 = System.currentTimeMillis();
        System.err.println(convert);
        System.err.println("用时："+(l1-l));

    }


    public static String convert(String s, int numRows) {
        String[] strings = s.split("");
        if (numRows==1){
            return s;
        }
        int col = s.length()/2+1;
        String[][] rowStrings = new String[numRows][col];
        for (int i = 0;i < numRows;i++) {
            for (int j = 0;j < col;j++){
                int length;
                if (j%(numRows-1)==0){
                    length = 2*j+i+1;
                }else {
                    length = 2*j-j%(numRows-1)+numRows;
                }
                if (length > strings.length){
                    break;
                }
                rowStrings[i][j] = strings[length-1];
            }
        }

        String res = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0;j < rowStrings[i].length;j++){
                if (j%(numRows-1)==0 || (j+i-numRows+1)%(numRows-1)==0){
                    if (rowStrings[i][j] != null){
                        res += rowStrings[i][j];
                    }
                    System.err.print(rowStrings[i][j]+" ");
                }else{
                    System.err.print("  ");
                }
            }
            System.err.println();
        }

        return res;
    }


    public static int reverse(int x) {
        int result = 0;
        long lx = Long.valueOf(x);
        if (lx < 0) {
            lx = 0-lx;
        }
        String s = String.valueOf(lx);
        String[] split = s.split("");
        String[] res = new String[split.length];
        for (int i = 0 ; i<split.length;i++){
            int b = split.length;
            res[b-1-i] = split[i];
        }

        String joins = "";
        for (String join : res){
            joins+=join;
        }
        Long b = Long.parseLong(joins);
        if (b > Long.valueOf(String.valueOf(Integer.MAX_VALUE))+1) {
            result = 0;
        } else {
            result = Integer.parseInt(b.toString());
        }

        if (x < 0) {
            result = 0 - result;
        }

        return result;
    }
}
