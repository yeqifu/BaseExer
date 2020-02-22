package com.yeqifu.exer03;

/**
 * 获取“ab”在“abkkcadkabkebfkabkskab”中出现的次数
 * @Author: 落亦-
 * @Date: 2020/2/21 10:45
 */
public class CountNum {

    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int index=0;
        int count=0;
        while ((index = mainStr.indexOf(subStr,index))!=-1){
            count++;
            index+=subLength;
        }
        return count;

    }

    public static void main(String[] args) {
        CountNum countNum = new CountNum();
        System.out.println(countNum.getCount("abkkcadkabkebfkabkskab","ab"));

    }


}
