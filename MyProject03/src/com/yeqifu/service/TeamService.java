package com.yeqifu.service;

import com.yeqifu.domain.Architect;
import com.yeqifu.domain.Designer;
import com.yeqifu.domain.Employee;
import com.yeqifu.domain.Programmer;

/**
 * @Author: 落亦-
 * @Date: 2020/2/16 13:41
 */
public class TeamService {
    /**
     * 给memberId赋值
     */
    private static int counter = 1;
    /**
     * 限制开发团队的最大人数
     */
    private final int MAX_MEMBER = 5;
    /**
     * 保存开发团队的成员对象
     */
    private Programmer[] team = new Programmer[MAX_MEMBER];
    /**
     * 记录开发团队的实际人数
     */
    private int total = 0;

    public TeamService() {
    }

    /**
     * 获取开发团队的所有成员
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] employees = new Programmer[total];
        for (int i = 0; i < total; i++) {
            employees[i]=team[i];
        }
        return employees;
    }

    /**
     * 向团队中添加成员
     * @param e     待添加成员的对象
     */
    public void addMember(Employee e) throws TeamException{
        if (total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer p = (Programmer)e;
        if (isExist(e)){
            throw new TeamException("该成员已在本开发团队");
        }
        if ("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员");
        }else if ("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");
        }
        //团队中至多只能有一名架构师
        //团队中至多只能有两名设计师
        //团队中至多只能有三名程序员
        int architectCount=0;
        int designerCount=0;
        int programmerCount=0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                architectCount++;
            }else if (team[i] instanceof Designer){
                designerCount++;
            }else if (team[i] instanceof Programmer){
                programmerCount++;
            }
        }
        if (e instanceof Architect){
            if (architectCount>=1){
                throw new TeamException("团队中至多只能有一名架构师");
            }else if (designerCount>=2){
                throw new TeamException("团队中至多只能有两名设计师");
            }else if (programmerCount>=3){
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        //将e添加到现有的team中
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++]=p;
    }

    /**
     * 判断此成员是否已在开发团队中
     * @param e     此成员
     * @return
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (e.getId().equals(team[i].getId())){
                return true;
            }
        }
        return false;
    }

    /**
     * 移除团队中的成员
     * @param memberId  要移除的成员的Id
     */
    public void removeMember(int memberId) throws TeamException{
        int i = 0;
        for ( ; i < total; i++) {
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        //未找到memberId的情况
        if (i==total){
            throw new TeamException("找不到指定memberId的员工,删除失败");
        }

        //后一个元素覆盖前一个元素，实现删除操作
        for (int j = i+1;j<total; j++) {
            team[j-1] = team[j];
        }
        team[total-1]=null;
        total--;
    }


}
