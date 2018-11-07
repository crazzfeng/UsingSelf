package kpm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yufeng li
 * @title: next
 * @description:
 * @date 2018/11/7 18:00
 */
public class next {

    public static Map getNext(String child){
        Map<Integer,Integer> map = new HashMap<>();
        char[] str = child.toCharArray();
        StringBuffer pit = new StringBuffer();
        for (int k = 0 ; k < str.length ; k++){
             pit.append(str[k]);
             char[] str1 = pit.toString().toCharArray();
             int i = k;
             int lenth = 0;
             while (i>0){
                 char[] qian = getChar1(i,str1);
                 char[] hou = getChar2(i,str1);
                   if (getComp(qian,hou)){
                     lenth = qian.length;
                     break;
                 }
                 else {
                     i--;
                 }
             }
            map.put(k,lenth);
            System.err.print(pit.toString() + ":"+lenth + "\n");
        }
        return map;
    }


    public static char[] getChar1(int i, char[] chars){
        char[] s = new char[i];
        for (int a =0;a < i;a++) {
            s[a] = chars[a];
        }
        return s;
    }

    public static char[] getChar2(int i, char[] chars){
        char[] s = new char[i];
        int le = chars.length;
        for (int a = 0;a < i ;a++) {
            s[i-a-1] = chars[le-a-1];
        }
        return s;
    }

    public static boolean getComp(char[] char1, char[] char2){
        int le = char1.length;
        for (int a = 0;a < le ;a++) {
            if (char1[a] != char2[a]){
                return false;
            }
        }
        return true;
    }
}
