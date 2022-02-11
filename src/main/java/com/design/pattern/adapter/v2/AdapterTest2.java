package com.design.pattern.adapter.v2;

public class AdapterTest2 {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.output5v();
    }
}

class Adaptee{ //受改造者
    int output220v(){
        return 220;
    }
}
interface Target{
    int output5v();
}

//类的适配器模式
class Adapter extends Adaptee implements Target{
    @Override
    public int output5v() {
        int i = this.output220v();
        //...
        System.out.println(String.format("原始电压: %d -> 输出电压：5v",i));
        return 5;
    }
}
