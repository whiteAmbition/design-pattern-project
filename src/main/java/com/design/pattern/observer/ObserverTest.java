package com.design.pattern.observer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ObserverTest {
    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        Subject subject = new Subject();
        Observer task1 = new Task1();
        Observer task2 = new Task2();
        subject.addObserver(task1);
        subject.addObserver(task2);

        ObjectMapper objectMapper = new ObjectMapper();
        Msg msg = new Msg("tom", 12);
        String json = objectMapper.writeValueAsString(msg);
        subject.notifyObserver(json);

        subject.removeObserver(task1);

        System.out.println("=================");
        subject.notifyObserver(json);

        TimeUnit.SECONDS.sleep(1);
        System.out.println(msg);
        subject.closeThreadPool();
        //源码引用
        Observable observable;
        ApplicationListener applicationListener;

    }
}

class Msg{
    private String name;
    private int age;
    public Msg(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Subject{
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    //容器
    private List<Observer> container=new ArrayList<>();
    //add
    public void addObserver(Observer observer){
        container.add(observer);
    }
    //remove
    public void removeObserver(Observer observer){
        container.remove(observer);
    }
    //notify
    public void notifyObserver(Object object){
        for (Observer observer : container) {
            executorService.submit(()->{
                try {
                    observer.update(object);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void closeThreadPool(){
        if(!executorService.isShutdown()){
            executorService.shutdown();
        }
    }

}

interface Observer{
    void update(Object object) throws InterruptedException;
}

class Task1 implements Observer{
    @Override
    public void update(Object object){
        System.out.println("Task1 received:"+object);
        if(object instanceof Msg){
            Msg msg = (Msg) object;
            msg.setName("Jane");
            msg.setAge(10);
        }
    }
}
class Task2 implements Observer{
    @Override
    public void update(Object object){
        System.out.println("Task2 received:"+object);
        if(object instanceof Msg){
            Msg msg = (Msg) object;
            msg.setName("Maria");
            msg.setAge(11);
        }
    }
}
