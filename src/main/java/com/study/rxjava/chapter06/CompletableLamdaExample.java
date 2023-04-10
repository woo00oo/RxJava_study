package com.study.rxjava.chapter06;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 데이터 생산자이지만 데이터를 1건도 통지하지 않고 완료 또는 에러를 통지.
 * 데이터 통지의 역할 대신에 Completable 내에서 특정 작업을 수행한 후, 해당 처리가 끝났음을 통지하는 역할
 *
 */
public class CompletableLamdaExample {

    public static void main(String[] args) {
        Completable completable = Completable.create(emitter -> {
            // 데이터를 발행하는것이 아니라 특정 작업을 수행한 후, 완료를 통지한다.
            int sum = 0;
            for(int i=0; i < 100; i++) {
                sum += i;
            }
            Logger.log(LogType.PRINT, "# 합계: " + sum);

            emitter.onComplete();

        });

        completable.subscribeOn(Schedulers.computation())
                .subscribe(
                        () -> Logger.log(LogType.ON_COMPLETE),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(1000L);

    }

}
