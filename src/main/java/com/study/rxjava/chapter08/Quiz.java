package com.study.rxjava.chapter08;

import com.study.rxjava.common.Car;
import com.study.rxjava.common.CarType;

import java.util.List;
import java.util.function.*;

public class Quiz {

    public static void main(String[] args) {

        /**
         * ClassName::instance method
         * s -> s.isEmpty()
         */
        Predicate<String> p = String::isEmpty;

        /**
         * ClassName::static method
         * i -> String.valueOf(i)
         */
        Function<Integer, String> f = String::valueOf;

        /**
         *  ClassName::instance method
         *  (list, num) -> list.contains(num)
         */
        BiPredicate<List<Integer>, Integer> bp = List::contains;

        /**
         * s-> System.out.println(s)
         */
        Consumer<String> c = System.out::println;

        /**
         * (s1, s2) -> new Car(s1, s2)
         */
        BiFunction<String, CarType, Car> bf = Car::new;

    }

}
