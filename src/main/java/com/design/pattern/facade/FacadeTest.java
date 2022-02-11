package com.design.pattern.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FacadeTest {
    public static void main(String[] args) {

    }
}

class Client{
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();
    public void doSomething(){
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}
class Client2{
    Facade facade = new Facade();
    public void doSomething(){
        facade.doSomethingFacade();
    }
}

class Facade{
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();
    public void doSomethingFacade(){
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

class SubSystem1{
    public void method1(){
        System.out.println("SubSystem1.method1 executed. ");
    }
}
class SubSystem2{
    public void method2(){
        System.out.println("SubSystem2.method2 executed. ");
    }
}
class SubSystem3{
    public void method3(){
        System.out.println("SubSystem3.method3 executed. ");
    }
}
