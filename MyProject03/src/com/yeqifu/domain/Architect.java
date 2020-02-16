package com.yeqifu.domain;

/**
 * @Author: 落亦-
 * @Date: 2020/2/15 20:23
 */
public class Architect extends Designer {
    private Integer stock;

    public Architect() {
    }

    public Architect(Integer id, String name, Integer age, Double salary, Equipment equipment, Double bonus, Integer stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }
}
