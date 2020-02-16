package com.yeqifu.abstractexer.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/2/13 12:13
 */
public class ComparableCircle extends Circle implements CompareObject {


    public ComparableCircle(Integer redius) {
        super(redius);
    }


    @Override
    public int compareTo(Object o) {
        if (this==o){
            return 0;
        }
        if (o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle)o;
            /*if (this.getRedius()>c.getRedius()){
                return 1;
            }else if (this.getRedius()<c.getRedius()){
                return -1;
            }else {
                return 0;
            }*/
            return this.getRedius().compareTo(c.getRedius());
        }else {
            throw new RuntimeException("传入数据类型不匹配");
        }
    }
}
