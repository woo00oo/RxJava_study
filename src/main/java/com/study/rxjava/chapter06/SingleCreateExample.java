package com.study.rxjava.chapter06;

import com.study.rxjava.utils.DateUtil;
import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 데이터를 1건만 통지하거나 에러를 통지
 *
 */
public class SingleCreateExample {

    public static void main(String[] args) {
        Single<String> single = Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> emitter) throws Throwable {
                emitter.onSuccess(DateUtil.getNowDate());
            }
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                // 아무것도 하지 않음.
            }

            @Override
            public void onSuccess(@NonNull String data) {
                Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data);
            }

            @Override
            public void onError(@NonNull Throwable error) {
                Logger.log(LogType.ON_ERROR, error);
            }
        });

    }

}
