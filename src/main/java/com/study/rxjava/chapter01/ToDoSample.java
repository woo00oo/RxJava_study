package com.study.rxjava.chapter01;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * - 리액티브 프로그래밍의 기본적인 규칙
 *
 *   Observable.just() -> 데이터 발행
 *   filter() -> 데이터 가공
 *   subscribe() -> 데이터 구독
 *
 *   subscribeOn() -> 데이터 발행 및 데이터 흐름을 결정
 *   observeOn() -> 발행된 데이터를 가공 및 구독하여 처리
 *
 */
public class ToDoSample {

    public static void main(String[] args) throws InterruptedException {
        Observable.just(100, 200, 300, 400, 500)
                .doOnNext(data -> System.out.println(getThreadName() + " : " + "#doOnNext() : " + data))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(number -> number > 300)
                .subscribe(num -> System.out.println(getThreadName() + " : result : " + num));

        Thread.sleep(500);

    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

}
