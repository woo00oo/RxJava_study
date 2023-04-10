package com.study.rxjava.chapter05;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 통지된 데이터로 채워진 버퍼의 데이터를 소비자가 모두 소비하면 버퍼 밖에서 대기중인 통지된 데이터 중에서
 * 가장 나중에(최근에) 통지된 데이터부터 다시 버퍼에 채운다.
 *
 */
public class BackpressureLatestExample {

    public static void main(String[] args) {
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log("#inverval doOnNext()", data))
                .onBackpressureLatest()
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(5500L);

    }

}
