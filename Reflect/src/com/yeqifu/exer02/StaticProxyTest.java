package com.yeqifu.exer02;

/**
 * 静态代理
 * @Author: 落亦-
 * @Date: 2020/2/29 16:34
 */
interface Perform{
    /**
     * 唱歌
     * @return
     */
    void song(String songName);

    /**
     * 与歌迷互动
     */
    void activity(String form);
}

/**
 * 声明一个被代理类
 */
class SingerProxy implements Perform{

    @Override
    public void song(String songName) {
        System.out.println(songName);
        System.out.println("代理类唱歌");
    }

    @Override
    public void activity(String form) {
        System.out.println(form);
    }

}

/**
 * 声明一个代理类
 */
class AgentPerson implements Perform{

    private Perform perform;

    public AgentPerson(Perform perform){
        this.perform = perform;
    }

    @Override
    public void song(String songName) {
        System.out.println("来首歌...");
        perform.song(songName);
    }

    @Override
    public void activity(String form) {
        System.out.println("打个招呼....");
        perform.activity(form);
    }
}

/**
 * @author luoyi-
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类对象
        SingerProxy singerProxy = new SingerProxy();
        //创建代理类对象   将被代理类对象的实例传入到构造方法中
        Perform agentPerson = new AgentPerson(singerProxy);
        //代理对象调用
        agentPerson.song("Love Story");
        agentPerson.activity("你好");
    }
}
