package com.design.pattern.template;

import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class TemplateTest {
    public static void main(String[] args) throws ServletException, IOException {
        AbstractClass abstractClass = new SubClass1();
        abstractClass.operation();
        //模板方法模式-源码中的应用
        HttpServlet httpServlet = null; //HttpServlet的service方法定义了骨架，可以通过重写doGet或者doPost达到模板方法方式应用
        httpServlet.service(null,null);
        //AbstractController的handleRequest方法是模板方法模式的骨架，用户只需要重写handleRequestInternal方法
        AbstractController abstractController;//Convenient superclass for controller implementations, using the Template Method design pattern.
    }
}

abstract class AbstractClass{
    public void operation(){
        //open
        System.out.println("pre...");
        System.out.println("step1...");
        System.out.println("step2...");
        //sql
        templateMethod();
        //close
        System.out.println("close...");
    }
    protected abstract void templateMethod();
}

class SubClass1 extends AbstractClass{
    @Override
    protected void templateMethod() {
        System.out.println("SubClass execute templateMethod...");
    }
}
class SubClass2 extends AbstractClass{
    @Override
    protected void templateMethod() {
        System.out.println("SubClass execute templateMethod...");
    }
}
