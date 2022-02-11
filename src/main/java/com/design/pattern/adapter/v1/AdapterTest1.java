package com.design.pattern.adapter.v1;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.AbstractApplicationEventMulticaster;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.GenericApplicationListenerAdapter;

import java.util.Collections;

public class AdapterTest1 {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.output5v();
        //源码应用 ApplicationListener -->ApplicationEventMulticaster.multicastEvent() -->
        // AbstractApplicationEventMulticaster.getApplicationListeners()->retrieveApplicationListeners()->supportsEvent()
        //supportsEvent
        ApplicationListener applicationListener;//这个只是一个入口，不是实际的适配器模式
        ApplicationEventMulticaster applicationEventMulticaster=null;
        AbstractApplicationEventMulticaster abstractApplicationEventMulticaster;
        //GenericApplicationListenerAdapter里面使用了对象适配器模式（组合的方式，内部有一个ApplicationListener对象）
        new GenericApplicationListenerAdapter(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {

            }
        });
    }
}
class Adaptee{
    public int output220v(){
        return 220;
    }
}
interface Target{
    int output5v();
}

//object adapter
class Adapter implements Target{
    //使用组合的方式
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();
        //...
        System.out.println(String.format("原始电压：%d -> 输出电压：5v",i));
        return 5;
    }
}
