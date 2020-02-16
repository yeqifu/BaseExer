package com.yeqifu.fengzhuang;

/**
 * @Author: 落亦-
 * @Date: 2020/1/8 17:19
 */
public class TriAngleTest02 {

    public static void main(String[] args) {
        TriAngle triAngle = new TriAngle(3,4);
        int area = triAngle.getBase() * triAngle.getHeight()/2;
        System.out.println(area);
    }

}

class TriAngle{
    private Integer base;
    private Integer height;
    public TriAngle(){

    }

    public TriAngle(Integer b,Integer h){
        base = b;
        height = h;
    }

    public void setBase(Integer b){
        base=b;
    }

    public int getBase(){
        return base;
    }

    public void setHeight(Integer h){
        height = h;
    }

    public int getHeight(){
        return height;
    }
}
