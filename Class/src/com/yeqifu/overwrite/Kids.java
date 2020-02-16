package com.yeqifu.overwrite;

/**
 * @Author: 落亦-
 * @Date: 2020/1/12 14:36
 */
public class Kids extends ManKind {
    private int yearsOld;


    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public Kids(int sex, int salary, int yearsOld) {
        super(sex, salary);
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println(this.yearsOld);
    }

    @Override
    public void employeed(){
        System.out.println("Kids should study and no job");
    }
}
