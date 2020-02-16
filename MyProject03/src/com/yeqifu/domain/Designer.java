package com.yeqifu.domain;

import com.yeqifu.service.Status;

/**
 * @Author: 落亦-
 * @Date: 2020/2/15 20:20
 */
public class Designer extends Programmer {

    private Double bonus;

    public Designer(){

    }

    public Designer(Integer memberId, Status status, Equipment equipment, Double bonus) {
        super(memberId, status, equipment);
        this.bonus = bonus;
    }

    public Designer(Integer id, String name, Integer age, Double salary, Equipment equipment, Double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t\t"+getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t设计师\t" + getBonus();
    }
}
