package com.study.rxjava.chapter05;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * interval() : 지정한 간격마다 0부터 시작해 Long 타입 숫자의 데이터를 송신하는 Flowable 을 생성
 * doOnNext() : 어떤 데이터를 발행할 때 호출
 * observeOn() : 데이터를 처리하는 쓰레드를 분리
 *
 */
public class MissingBackpressureExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            Logger.log(LogType.PRINT, "# 소비자 처리 대기 중..");
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.DO_ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.DO_ON_COMPLETE)
                );

        Thread.sleep(2000L);
    }

}
