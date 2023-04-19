package com.study.rxjava.chapter10;

import com.study.rxjava.common.Car;
import com.study.rxjava.common.SampleData;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

/**
 * 파라미터로 지정한 조건이 될 때까지 데이터를 계속 발행
 *
 */
public class ObservableTakeUntilExample01 {

    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .takeUntil((Car car) -> car.getCarName().equals("트랙스"))
                .subscribe(car -> System.out.println(car.getCarName()));

        TimeUtil.sleep(300L);

    }

}
