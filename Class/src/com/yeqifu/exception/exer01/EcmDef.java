package com.yeqifu.exception.exer01;

import java.util.Scanner;

/**
 * @Author: 落亦-
 * @Date: 2020/2/15 9:54
 */
public class EcmDef {

    public static int ecm(int a,int b) throws EcDef{
        if (a<0||b<0){
            throw new EcDef("分子或分母为负数了");
        }
        return a/b;
    }

    public static void main(String[] args) {

        try {
            Integer a = Integer.parseInt(args[0]);
            Integer b = Integer.parseInt(args[1]);

            ecm(a,b);

        }catch (NumberFormatException e){
            System.out.println("数据类型不一致");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch (EcDef ecDef) {
            System.out.println(ecDef.getMessage());
        }


    }
}

class EcDef extends Exception{
    static final long serialVersionUID = -2414234234234234234L;

    public EcDef(){

    }
    public EcDef(String msg){
        super(msg);
    }
}
