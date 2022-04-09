package com.study.rxjava;

import io.reactivex.Observable;

public class HelloRxjava {

    public static void main(String[] args) {
        //pub
        Observable<String> observable = Observable.just("Hello", "Rxjava");
        //sub
        observable.subscribe(data -> System.out.println("data = " + data) );
    }
}
