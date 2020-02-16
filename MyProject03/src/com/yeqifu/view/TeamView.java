package com.yeqifu.view;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.yeqifu.domain.Employee;
import com.yeqifu.domain.Programmer;
import com.yeqifu.service.NameListService;
import com.yeqifu.service.TeamException;
import com.yeqifu.service.TeamService;

/**
 * @Author: 落亦-
 * @Date: 2020/2/16 17:41
 */
public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public TeamView() {
    }

    public void enterMainMenu(){

        boolean loopFlag = true;
        char c=0;
        while (loopFlag){
            if (c != '1') {
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            c = TSUtility.readMenuSelection();
            switch (c){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否确认退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        loopFlag = false;
                    }
                    break;
                default:
            }
        }

    }

    /**
     * 显示所有的员工信息
     */
    private void listAllEmployees(){
        System.out.println("------------------------------开发团队调度软件-------------------------------");
        System.out.println("ID\t\t姓名\t\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t设备");
        Employee[] allEmployees = listSvc.getAllEmployees();
        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    private void getTeam(){
        System.out.println("--------------------------------团队成员列表---------------------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0){
            System.out.println("开发团队目前没有成员！");
        }else {
            System.out.println("TID/ID\t姓名\t\t\t年龄\t工资\t\t状态\t\t职位\t\t奖金\t\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    private void addMember(){
        System.out.println("--------------------------------添加团队成员---------------------------------");
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember(){
        System.out.println("--------------------------------添加团队成员---------------------------------");
        System.out.println("请输入要删除的员工TID:");
        int memberId = TSUtility.readInt();
        System.out.println("确认是否删除(Y/N):");
        char c = TSUtility.readConfirmSelection();
        if (c=='N'){
            return;
        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");

        } catch (TeamException e) {
            System.out.println("删除失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();

    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

}
