package com.study.rxjava.chapter10;

import com.study.rxjava.common.CarMaker;
import com.study.rxjava.common.SampleData;
import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

public class Quiz1 {

    public static void main(String[] args) {

        Observable.fromIterable(SampleData.carList)
                .filter(car -> car.getCarMaker().equals(CarMaker.SSANGYOUNG))
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));

    }

}
