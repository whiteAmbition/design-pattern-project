package com.design.pattern.builder;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

public class BuilderTest {
    public static void main(String[] args) {
//        Product product = new Product();
//        product.setProductName("");
//        product.setCompanyName("");
//        product.setPart1("");
//        product.setPart2("");
//        product.setPart3("");
//        product.setPart4("");
//        ProductBuilder productBuilder = new DefaultConcreteProductBuilder();
        ProductBuilder productBuilder = new SpecialConcreteProductBuilder();
        Director director = new Director(productBuilder);

        Product product = director.makeProduct("", "", "", "", "", "");
        System.out.println(product);
        //源码中的建造者模式
        RequestMappingInfo.Builder requestMappingInfoBuilder;
        BeanDefinitionBuilder beanDefinitionBuilder;
    }
}

class Director{
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4){
        builder.buildProductName(productName);
        builder.buildCompanyName(companyName);
        builder.buildPart1(part1);
        builder.buildPart2(part2);
        builder.buildPart3(part3);
        builder.buildPart4(part4);
        return builder.build();
    }
}

interface ProductBuilder{
    void buildProductName(String productName);
    void buildCompanyName(String companyName);
    void buildPart1(String part1);
    void buildPart2(String part2);
    void buildPart3(String part3);
    void buildPart4(String part4);
    Product build();
}

class DefaultConcreteProductBuilder implements ProductBuilder{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    @Override
    public void buildProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void buildCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public void buildPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void buildPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void buildPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void buildPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build(){
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}

class SpecialConcreteProductBuilder implements ProductBuilder{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    @Override
    public void buildProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void buildCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public void buildPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void buildPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void buildPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void buildPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build(){
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}

class Product{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public Product() {
    }

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }
}
