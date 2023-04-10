package com.study.rxjava.chapter06;

import com.study.rxjava.utils.DateUtil;
import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Single;

public class SingleLamdaExample {

    public static void main(String[] args) {
        Single<String> single = Single.create(emitter -> emitter.onSuccess(DateUtil.getNowDate()));

        single.subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각 : " + data),
                error -> Logger.log(LogType.ON_ERROR, error)
        );

    }

}
