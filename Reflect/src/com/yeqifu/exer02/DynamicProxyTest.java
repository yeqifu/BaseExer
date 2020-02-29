package com.yeqifu.exer02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: 落亦-
 * @Date: 2020/2/29 21:47
 */
interface Human{
    /**
     * 获得信仰
     * @return
     */
    String getBelief(String belief);

    /**
     * 获得所吃的食物
     */
    void getEatFood(String food);

}

/**
 * 被代理类
 */
class SuperMan implements Human{

    @Override
    public String getBelief(String belief) {
        return belief;
    }

    @Override
    public void getEatFood(String food) {
        System.out.println("我吃"+food);
    }
}

class ProxyFactory{

    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}

/**
 * @author luoyi-
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief("科学"));
        proxyInstance.getEatFood("米饭");
    }
}
