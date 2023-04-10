package com.study.rxjava.chapter06;

import com.study.rxjava.utils.DateUtil;
import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class MaybeFromSingle {

    public static void main(String[] args) {
        Single<String> single = Single.just(DateUtil.getNowDate());

        Maybe.fromSingle(single)
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

    }

}
