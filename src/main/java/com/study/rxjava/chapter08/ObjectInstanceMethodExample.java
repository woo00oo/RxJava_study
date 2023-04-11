package com.study.rxjava.chapter08;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Object::instance method 예
 *
 */
public class ObjectInstanceMethodExample {

    public static void main(String[] args) {
        final CarInventory carInventory = new CarInventory(10);

        Function<Integer, Integer> f1 = count -> carInventory.getExpectedTotalCount(count);
        Integer totalCount1 = f1.apply(10);
        System.out.println("totalCount1 = " + totalCount1);

        Function<Integer, Integer> f2 = carInventory::getExpectedTotalCount;
        Integer totalCount2 = f2.apply(20);
        System.out.println("totalCount2 = " + totalCount2);

        // T -> T
        UnaryOperator<Integer> f3 = carInventory::getExpectedTotalCount;
        Integer totalCount3 = f3.apply(30);
        System.out.println("totalCount3 = " + totalCount3);

        // Integer -> Integer
        IntUnaryOperator f4 = carInventory::getExpectedTotalCount;
        int totalCount4 = f4.applyAsInt(40);
        System.out.println("totalCount4 = " + totalCount4);

    }

}
