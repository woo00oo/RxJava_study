package com.study.rxjava.chapter09;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

import java.time.LocalTime;

/**
 * defer
 *
 *  - 구독이 발생할 때마다 즉, subscribe() 가 호출될 때 마다 새로운 Observable을 생성
 *  - 선언한 시점의 데이터를 통지하는 것이 아니라 호출 시점의 데이터를 통지
 *  - 데이터 생성을 미루는 효과가 있기 때문에 최신 데이터를 얻고자할 때 활용
 *
 */
public class ObservableDeferExample {

    public static void main(String[] args) throws InterruptedException {
        Observable<LocalTime> observable = Observable.defer(() -> {
            LocalTime currentTime = LocalTime.now();
            return Observable.just(currentTime);
        });

        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observable.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독1의 구독 시간:" + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독1의 구독 시간:" + time));

        Thread.sleep(3000);

        observable.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독2의 구독 시간:" + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독2의 구독 시간:" + time));

    }

}
