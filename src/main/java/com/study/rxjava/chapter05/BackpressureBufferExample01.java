package com.study.rxjava.chapter05;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * - DROP_LATEST 전략 : 생산자쪽에서 데이터 통지 시점에 버퍼가 가득 차 있으면 버퍼내에 있는 데이터 중에서 가장 최근에 버퍼
 * 안에 들어온 데이터를 삭제하고 버퍼 밖에서 대기하는 데이터를 그 자리에 채운다.
 *
 */
public class BackpressureBufferExample01 {

    public static void main(String[] args) {
        System.out.println("# start : " + TimeUtil.getCurrentTimeFormatted());
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log("#inverval doOnNext()", data))
                .onBackpressureBuffer(
                        2,
                        () -> Logger.log("overflow!"),
                        BackpressureOverflowStrategy.DROP_LATEST)
                .doOnNext(data -> Logger.log("#onBackpressureBuffer doOneNext()", data))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.DO_ON_NEXT, data);
                        },
                        error -> {
                            Logger.log(LogType.ON_ERROR, error);
                        }
                );

        TimeUtil.sleep(2800L);
    }

}
