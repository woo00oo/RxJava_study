package com.study.rxjava.chapter09;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * interval
 *
 * - 지정한 시간 간격마다 0부터 시작하는 숫자(Long)를 통지
 * - initialDelay 파라미터 이용해서 최초 통지에 대한 대기 시간을 지정
 * - 완료 없이 계속 통지
 * - 호출한 쓰레드와 별도의 쓰레드에서 실행
 * - polling 용도의 작업을 수행할 때 활용
 *
 */
public class ObservableIntervalExample {

    public static void main(String[] args) {
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .map(num -> num + " count")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);
    }

}
