package com.yeqifu.exer03;

import org.junit.Test;

/**
 * 获取“ab”在“abkkcadkabkebfkabkskab”中出现的次数
 *
 * @Author: 落亦-
 * @Date: 2020/2/21 10:45
 */
public class CountNum {

    /**
     * 获取subStr在mainStr中出现的次数
     *
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int index = 0;
        int count = 0;
        while ((index = mainStr.indexOf(subStr, index)) != -1) {
            count++;
            index += subLength;
        }
        return count;

    }

    public static void main(String[] args) {
        CountNum countNum = new CountNum();
        System.out.println(countNum.getCount("abkkcadkabkebfkabkskab", "ab"));

    }

    @Test
    public void sout() {
        int a = '2';
        System.out.println(a);
    }

    @Test
    public void test() {
        String s = null;
        int[] arr = new int[]{1, 2, 3};
        if ("null".equals(arr[3])) {
            System.out.println("123");
        }

    }

    @Test
    public void test02() {
        String[] arr = new String[]{"MM", "MM", "MM"};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "GG";
        }
        /*for(String s: arr){
            s="GG";
        }*/
        for (String s : arr) {
            System.out.println(s);
        }
    }

    @Test
    public void test03() {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length());
        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb2.length());
    }

    @Test
    public void test04() {
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "atguigu";
            System.out.println(myStr);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }

}
