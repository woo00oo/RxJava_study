package com.study.rxjava.chapter03;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hello", "RxJava");

        observable.subscribe(System.out::println);

    }
}
