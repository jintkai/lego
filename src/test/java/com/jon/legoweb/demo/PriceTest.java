package com.jon.legoweb.demo;

import java.util.ArrayList;

class Price{
    final static Price INSTANCE = new Price(2.8);
    static double initPrice =20;

    double currentPrice;
    public Price(double price){
        this.currentPrice = initPrice - price;
    }
}

public class PriceTest {

    public static void main(String[] args) {
        System.out.println(Price.INSTANCE.currentPrice);
        Price p = new Price(2.8);
        System.out.println(p.currentPrice);
        ArrayList a = new ArrayList(5);

    }
}

/**
 *  分析逻辑：
 * 1、jvm对java类初始化时，先为类变量分配空间。
 * 2、分配空间后，依次初始化类变量值；
 * 因此在第4行代码执行时，initPrice的值还是0
 *
 */