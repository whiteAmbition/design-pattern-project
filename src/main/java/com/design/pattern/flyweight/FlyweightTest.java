package com.design.pattern.flyweight;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightTest {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, 1, TreeFactory.getTree("a", "1"));
        System.out.println(treeNode1);
        TreeNode treeNode2 = new TreeNode(1, 2, TreeFactory.getTree("a", "1"));
        System.out.println(treeNode2);
        TreeNode treeNode3 = new TreeNode(2, 1, TreeFactory.getTree("b", "1"));
        System.out.println(treeNode3);

        //源码中的享元模式
        InstructionConstants instructionConstants;
    }
}
class TreeNode{
    private int x;
    private int y;
    private Tree tree;
    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

class TreeFactory{
    private static Map<String,Tree> map = new ConcurrentHashMap<>();
    public static Tree getTree(String name,String data){
        if(map.containsKey(name)){
            return map.get(name);
        }else{
            Tree tree = new Tree(name,data);
            map.put(name,tree);
            return tree;
        }
    }
}

//不可变对象使用享元模式
class Tree{
    private final String name;
    private final String data;
    public Tree(String name, String data) {
        this.name = name;
        this.data = data;
        System.out.println("New Tree is created,name:"+name);
    }
    public String getName() {
        return name;
    }
    public String getData() {
        return data;
    }
}
