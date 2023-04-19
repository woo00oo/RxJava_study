package com.study.rxjava.chapter10;

import com.study.rxjava.common.Car;
import com.study.rxjava.common.SampleData;
import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableDistinctExample03 {

    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .distinct(Car::getCarMaker)
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
    }

}
