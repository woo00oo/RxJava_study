package com.study.rxjava.chapter05;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * - DROP_OLDEST 전략 : 생산자쪽에서 데이터 통지 시점에 버퍼가 가득 차있으면 버퍼내에 있는 데이터 중에서 가장 먼저(OLDEST) 버퍼
 * 안에 들어온 데이터를 삭제하고 버퍼 밖에서 대기하는 데이터를 채운다.
 *
 */
public class BackpressureBufferExample02 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("# start : " + TimeUtil.getCurrentTimeFormatted());
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log("#inverval doOnNext()", data))
                .onBackpressureBuffer(
                        2,
                        () -> Logger.log("overflow!"),
                        BackpressureOverflowStrategy.DROP_OLDEST)
                .doOnNext(data -> Logger.log("#onBackpressureBuffer doOnNext()", data))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.DO_ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        Thread.sleep(2500L);

    }

}
