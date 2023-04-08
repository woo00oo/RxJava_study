package com.study.rxjava.chapter04;

import io.reactivex.rxjava3.processors.PublishProcessor;

/**
 * Hot Publisher
 *
 * - 생산자는 소비자 수와 상관없이 데이터를 한번만 통지
 * - 즉, 데이터를 통지하는 타임 라인은 하나
 * - 소비자는 발행된 데이터를 처음부터 전달 받는게 아니라 구독한 시점에 통지된 데이터들만 전달
 *
 */
public class HotPublisherExample {

    public static void main(String[] args) {
        PublishProcessor<Integer> processor = PublishProcessor.create();
        processor.subscribe(data -> System.out.println("구독자1: "+ data));
        processor.onNext(1);
        processor.onNext(3);

        processor.subscribe(data -> System.out.println("구독자2: "+ data));
        processor.onNext(5);
        processor.onNext(7);

        processor.onComplete();

    }

}
