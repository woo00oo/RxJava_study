package com.study.rxjava.chapter03.chapter0302;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MissingBackpressureExceptionExample {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println(data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            System.out.println("# 소비자 처리 대기중..");
                            Thread.sleep(1000L);
                            System.out.println(data);
                        },
                        System.out::println,
                        System.out::println
                );
        Thread.sleep(2000);
    }
}
