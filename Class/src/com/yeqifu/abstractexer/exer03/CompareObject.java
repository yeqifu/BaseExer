package com.yeqifu.abstractexer.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/2/13 12:08
 */
public interface CompareObject {
    /**
     * 实现两个对象的比较
     * @param o     对象的实例
     * @return      0：相等    >0:当前对象大    <0:当前对象小
     */
    public int compareTo(Object o);
}
