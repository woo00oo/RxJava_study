package com.study.rxjava.chapter09;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * timer
 *
 *  - 지정한 시간이 지나면 0(Long)을 통지
 *  - 0을 통지하고 onComplete() 이벤트가 발생하여 종료
 *  - 호출한 쓰레드와는 별도의 쓰레드에서 실행
 *  - 특정 시간을 대기한 후에 어떤 처리를 하고자 할때 활용
 *
 */
public class ObservableTimerExample {

    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# Start!");
        Observable<String> observable =
                Observable.timer(2000, TimeUnit.MILLISECONDS)
                        .map(count -> "Do work!");

        observable.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);

    }

}
