package com.study.rxjava.chapter10;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import com.study.rxjava.utils.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Quiz2 {

    public static void main(String[] args) {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .takeWhile(data -> data != 10)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(10000L);
    }

}
