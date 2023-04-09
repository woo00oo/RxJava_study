package com.study.rxjava.chapter06;

import com.study.rxjava.common.DateUtil;
import com.study.rxjava.common.LogType;
import com.study.rxjava.common.Logger;
import io.reactivex.rxjava3.core.Maybe;

public class MaybeLamdaExample {

    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(emitter -> {
            emitter.onSuccess(DateUtil.getNowDate());
            emitter.onComplete();
        });

        maybe.subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

    }

}
