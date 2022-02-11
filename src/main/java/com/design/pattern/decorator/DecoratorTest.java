package com.design.pattern.decorator;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;

public class DecoratorTest {
    public static void main(String[] args) {
        //原始效果
        Component concreteComponent = new ConcreteComponent();
        concreteComponent.operation();
        System.out.println("===================");
        //装饰器模式
        Component decoratorComponent1 = new ConcreteDecorator1(concreteComponent);//添加美颜效果
        decoratorComponent1.operation();
        System.out.println("===================");
        Component decoratorComponent2 = new ConcreteDecorator2(decoratorComponent1);//添加美颜效果的基础上添加滤镜效果
        decoratorComponent2.operation();

        HttpServletRequestWrapper httpServletRequestWrapper;//This class implements the Wrapper or Decorator pattern.
        HttpServletResponseWrapper httpServletResponseWrapper;

    }
}

interface Component{
    void operation();
}
class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("拍照.");
    }
}
abstract class Decorator implements Component{
    Component component;
    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }
    @Override
    public void operation() {
        System.out.println("添加美颜效果.");
        component.operation();
    }
}

class ConcreteDecorator2 extends Decorator{
    public ConcreteDecorator2(Component component) {
        super(component);
    }
    @Override
    public void operation() {
        System.out.println("添加滤镜效果.");
        component.operation();
    }
}
