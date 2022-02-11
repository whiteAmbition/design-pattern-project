package com.design.pattern.responsibilitychain;

import javax.servlet.Filter;
import javax.servlet.FilterChain;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(true).loggedOn(false).build();
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        boolean process = requestFrequentHandler.process(request);
        if(process){
            System.out.println("校验通过，正常业务处理");
        }else{
            System.out.println("校验未通过，访问异常");
        }
        //源码应用
        javax.servlet.Filter filter;
        //Filters use the FilterChain to invoke the next filter in the chain,
        // or if the calling filter is the last filter in the chain, to invoke the resource at the end of the chain.
        javax.servlet.FilterChain filterChain;
    }
}

class Request{
    private boolean loggedOn;
    private boolean frequentOk;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }
    public boolean isFrequentOk() {
        return frequentOk;
    }
    public boolean isPermits() {
        return isPermits;
    }
    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }

    static class RequestBuilder{
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;
        RequestBuilder loggedOn(boolean loggedOn){
            this.loggedOn=loggedOn;
            return this;
        }
        RequestBuilder frequentOk(boolean frequentOk){
            this.frequentOk=frequentOk;
            return this;
        }
        RequestBuilder isPermits(boolean isPermits){
            this.isPermits=isPermits;
            return this;
        }
        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords){
            this.containsSensitiveWords=containsSensitiveWords;
            return this;
        }
        public Request build() {
            return new Request(loggedOn,frequentOk,isPermits,containsSensitiveWords);
        }
    }
}

abstract class Handler{
    Handler next;
    public Handler(Handler next) {
        this.next = next;
    }
    public Handler getNext() {
        return next;
    }
    public void setNext(Handler next) {
        this.next = next;
    }
    abstract boolean process(Request request);
}
class RequestFrequentHandler extends Handler {
    public RequestFrequentHandler(Handler next) {
        super(next);
    }
    @Override
    boolean process(Request request) {
        if(request.isFrequentOk()){
            System.out.println("访问频率控制通过。。。");
            Handler next = getNext();
            if(next==null){
                return true;
            }
            return next.process(request);
        }
        System.out.println("访问频率控制未通过。。。");
        return false;
    }
}

class LoggingHandler extends Handler{
    public LoggingHandler(Handler next) {
        super(next);
    }
    @Override
    boolean process(Request request) {
        if(request.isLoggedOn()){
            System.out.println("登录验证通过。。。");
            Handler next = getNext();
            if(next==null){
                return true;
            }
            return next.process(request);
        }
        System.out.println("登录验证未通过。。。");
        return false;
    }
}
