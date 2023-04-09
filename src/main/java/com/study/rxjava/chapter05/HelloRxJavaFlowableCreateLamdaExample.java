package com.study.rxjava.chapter05;

import com.study.rxjava.common.LogType;
import com.study.rxjava.common.Logger;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HelloRxJavaFlowableCreateLamdaExample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable =
                Flowable.create(emitter -> {
                    String[] datas = {"Hello", "RxJava!"};
                    for (String data : datas) {
                        // 구독이 해지되면 처리 중단
                        if (emitter.isCancelled()) return;

                        // 데이터 발행
                        emitter.onNext(data);
                    }

                    // 데이터 발행 완료를 알린다
                    emitter.onComplete();
                }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE));

        Thread.sleep(500L);

    }

}
