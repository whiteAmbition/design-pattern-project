package com.design.pattern.strategy.v2;

public class StrategyTest {
    public static void main(String[] args) {
        Zombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
        System.out.println("----------普通僵尸 切换攻击方式--------");
        normalZombie.setAttackable(new HitAttack());//普通僵尸切换攻击方式
        normalZombie.attack();

        System.out.println("------------------");
        Zombie flagZombie = new FlagZombie();
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();

    }
}
interface Moveable{
    void move();
}
class StepByStepMove implements Moveable{
    @Override
    public void move() {
        System.out.println("一步一步移动。。。");
    }
}

interface Attackable{
    void attack();
}

class BitAttack implements Attackable{
    @Override
    public void attack() {
        System.out.println("咬。。。");
    }
}
class HitAttack implements Attackable{
    @Override
    public void attack() {
        System.out.println("打。。。");
    }
}

abstract class Zombie{
    protected Moveable moveable;
    protected Attackable attackable;
    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }
    public abstract void display();
    abstract void attack();
    abstract void move();
    public Moveable getMoveable() {
        return moveable;
    }
    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }
    public Attackable getAttackable() {
        return attackable;
    }
    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

class NormalZombie extends Zombie{
    public NormalZombie() {
        super(new StepByStepMove(), new BitAttack()); //默认一步一步移动，攻击方式是咬
    }
    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }
    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }
    @Override
    void attack() {
        attackable.attack();
    }
    @Override
    void move() {
        moveable.move();
    }
}

class FlagZombie extends Zombie{
    public FlagZombie() {
        super(new StepByStepMove(), new BitAttack()); //默认一步一步移动，攻击方式是咬
    }
    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }
    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }
    @Override
    void attack() {
        attackable.attack();
    }
    @Override
    void move() {
        moveable.move();
    }
}
