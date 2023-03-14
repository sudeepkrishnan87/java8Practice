package com.mytechexp;

import java.util.Arrays;
import java.util.List;

public class LogestPrefix {
    public static void main(String[] args) {
        List<String> prefix = Arrays.asList("abcd", "aze" );
        System.out.println(longestPrefix(prefix,0,prefix.size()-1));

    }

    private static String longestPrefix(List<String> prefix,int start,int end) {
        if(start==end)
            return prefix.get(start);
        if(end>start) {
            int mid = start + (end - start) / 2;
            String str1=longestPrefix(prefix,start,mid);
            String str2=longestPrefix(prefix,mid+1,end);

            return commonPrefix(str1,str2);
        }
        return null;
    }

    private static String commonPrefix(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        for (int i = 0, j = 0; i <= n1 - 1 &&
                j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }
}
