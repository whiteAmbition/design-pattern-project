package com.design.pattern.strategy.v3;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Person[] persons = new Person[]{new Person(10,111),new Person(18,99),new Person(15,122)};
//        Arrays.sort(persons,new SortByAge());
        Arrays.sort(persons,new SortByHeight());
        print(persons);
        //策略模式源码应用：Arrays.sort通过传入的Comparable接口的实现类确定排序规则
    }

    private static void print(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }
}

class Person {
    private int age;
    private int height;
    public Person(int age, int height) {
        this.age = age;
        this.height = height;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }
}

class SortByAge implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getAge()==p2.getAge()){
            return 0;
        }else if(p1.getAge()>p2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }
}
class SortByHeight implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getHeight()==p2.getHeight()){
            return 0;
        }else if(p1.getHeight()>p2.getHeight()){
            return 0;
        }else{
            return -1;
        }
    }
}
