package com.yeqifu.domain;

import com.yeqifu.service.Status;

/**
 * @Author: 落亦-
 * @Date: 2020/2/15 20:07
 */
public class Programmer extends Employee {
    /**
     * 在开发团队中的ID
     */
    private Integer memberId;
    private Status status=Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(Integer memberId, Status status, Equipment equipment) {
        this.memberId = memberId;
        this.status = status;
        this.equipment = equipment;
    }

    public Programmer(Integer id, String name, Integer age, Double salary,Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + getStatus() + "\t\t\t\t\t" + equipment.getDescription() ;
    }

    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails()+"\t"+getStatus();
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\t程序员";
    }
}
