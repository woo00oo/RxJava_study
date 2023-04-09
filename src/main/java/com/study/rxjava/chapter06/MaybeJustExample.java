package com.study.rxjava.chapter06;

import com.study.rxjava.common.DateUtil;
import com.study.rxjava.common.LogType;
import com.study.rxjava.common.Logger;
import io.reactivex.rxjava3.core.Maybe;

public class MaybeJustExample {

    public static void main(String[] args) {
        Maybe.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );


        Maybe.empty()
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

    }

}
