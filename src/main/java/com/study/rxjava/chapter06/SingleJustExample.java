package com.study.rxjava.chapter06;

import com.study.rxjava.utils.DateUtil;
import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Single;

public class SingleJustExample {

    public static void main(String[] args) {
        Single.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 날짜 시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
    }

}
