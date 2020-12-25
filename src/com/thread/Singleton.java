package com.thread;

public class Singleton {
    private Singleton(){

    }
//    volatile 保证jvm指令顺序一致，防止因为指令重排导致线程获得一个没有初始化的实例（jvm创建类实例：1.为实例分配内存空间 2.初始化实例 3.将实例指向初始化空间）
    public static volatile Singleton instance;
    public Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
