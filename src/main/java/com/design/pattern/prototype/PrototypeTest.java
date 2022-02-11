package com.design.pattern.prototype;

import org.springframework.beans.factory.support.AbstractBeanDefinition;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("a");
        Product product = new Product("part1", "part2", 3, 4,baseInfo);
        //new Product  ...
        Product clone = product.clone();
        System.out.println("original:\t"+product);
        System.out.println("clone:\t"+clone);
        //浅拷贝：修改可变数据类型的值，克隆对象也会修改
        baseInfo.setName("b");
        System.out.println("original baseInfo:\t"+product.getBaseInfo());
        System.out.println("clone baseInfo:\t"+clone.getBaseInfo());
        //注意：数组([]不包括集合)默认实现了Cloneable接口，但是它的拷贝是浅拷贝shallow copy具体查看clone()方法的注释
        Product[] productArr = {product};
        Product[] productArrClone = productArr.clone();
        System.out.println("productArr1:"+productArr[0].getBaseInfo());
        System.out.println("productArrClone1:"+productArrClone[0].getBaseInfo());
        baseInfo.setName("c");//此处由于数组是浅拷贝，所以clone的baseInfo也会随之修改
        System.out.println("productArr2:"+productArr[0].getBaseInfo());
        System.out.println("productArrClone2:"+productArrClone[0].getBaseInfo());

        BaseInfo baseInfoX = new BaseInfo("x");
        ArrayList<BaseInfo> list = new ArrayList<>();//List接口没有实现Cloneable接口；ArrayList实现了Cloneable接口，但是和数组一样也是浅拷贝
        list.add(baseInfoX);
        product.setBaseInfos(list);
        Product productHaveListClone = product.clone();
        baseInfoX.setName("y");
        System.out.println(product.getBaseInfos().get(0));
        System.out.println(productHaveListClone.getBaseInfos().get(0));

        //原型模式-源码应用
        AbstractBeanDefinition abstractBeanDefinition;//clone方法
        ArrayList arrayList;//clone方法
        Arrays arrays;
    }
}

class BaseInfo implements Cloneable,Serializable{
    private static final long serialVersionUID = -5946698852189955398L;
    private String name;
    public BaseInfo(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.hashCode()+"\t BaseInfo{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo)super.clone();
    }
}

class Product implements Cloneable,Serializable{
    private static final long serialVersionUID = -7186035669674537911L;
    private String part1;
    private String part2;
    private Integer part3;
    private Integer part4;
    private BaseInfo baseInfo;
    private List<BaseInfo> baseInfos;

    public Product(String part1, String part2, Integer part3, Integer part4,BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo = baseInfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        Product cloneProduct = null;

        //方式1：实现Cloneable接口，重写clone方法
//        cloneProduct = (Product) super.clone();
//        //可变数据类型的field要额外进行clone然后替换原来的引用
//        BaseInfo baseInfoClone = this.baseInfo.clone();
//        cloneProduct.setBaseInfo(baseInfoClone);
//        //集合对象的克隆需要创建新的集合，然后将老集合中的每一个对象分别复制一份放到新集合中，最后修改克隆的当前对象的集合引用
//        List<BaseInfo> newBaseInfos = new ArrayList<>();
//        if(this.baseInfos!=null && !this.baseInfos.isEmpty()){
//            for (BaseInfo baseInfo : baseInfos) {
//                newBaseInfos.add(baseInfo.clone());
//            }
//        }
//        cloneProduct.setBaseInfos(newBaseInfos);

        //方式2：还可以使用序列化的方式进行深拷贝，此种方式由于使用了序列化和反序列化所以需要实现Serializable接口
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        try(ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {
//            oos.writeObject(this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//        try (ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream)) {
//            cloneProduct = (Product)ois.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        return cloneProduct;
    }

    @Override
    public String toString() {
        return super.hashCode()+"\t Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3=" + part3 +
                ", part4=" + part4 +
                ", baseInfo=" + baseInfo +
                '}';
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public Integer getPart3() {
        return part3;
    }

    public void setPart3(Integer part3) {
        this.part3 = part3;
    }

    public Integer getPart4() {
        return part4;
    }

    public void setPart4(Integer part4) {
        this.part4 = part4;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<BaseInfo> getBaseInfos() {
        return baseInfos;
    }

    public void setBaseInfos(List<BaseInfo> baseInfos) {
        this.baseInfos = baseInfos;
    }
}

