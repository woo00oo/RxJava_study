package com.study.rxjava.chapter04;

import io.reactivex.rxjava3.core.Flowable;

/**
 *  Cold Publisher
 *
 *  - 생산자는 소비자가 구독 할때마다 데이터를 처음부터 새로 통지
 *  - 데이터를 통지하는 새로운 타임 라인 생성
 *  - 소비자는 구독 시점과 상관없이 통지된 데이터를 처음부터 전달
 *  - ex) Observable, Flowable
 *
 */
public class ColdPublisherExample {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(1, 3, 5, 6);

        flowable.subscribe(data -> System.out.println("구독자 1: " + data));
        flowable.subscribe(data -> System.out.println("구독자 2: " + data));

    }

}
