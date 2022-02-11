package com.design.pattern.strategy.v1;

public class ZombieTest {
    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
        System.out.println("-----------");
        AbstractZombie flagZombie = new FlagZombie();
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
    }
}

abstract class AbstractZombie{
    public abstract void display();
    public void attack(){
        System.out.println("咬.");
    }
    public void move(){
        System.out.println("一步一步移动.");
    }
}

class NormalZombie extends AbstractZombie{
    @Override
    public void display() {
        System.out.println("我是普通僵尸.");
    }
}
class FlagZombie extends AbstractZombie{
    @Override
    public void display() {
        System.out.println("我是旗手僵尸.");
    }
}
class BigHeadZombie extends AbstractZombie{
    @Override
    public void display() {
        System.out.println("我是大头僵尸.");
    }

    @Override
    public void attack() {
        //...实际是很复杂的功能
        System.out.println("头撞.");
    }
}

class XxxZombie extends BigHeadZombie{ //又新添了僵尸种类，他的攻击方式也是头撞
    @Override
    public void display() {
        System.out.println("我是xxx僵尸.");
    }

    @Override
    public void move() {
        System.out.println("xxxxx.");
    }
}
