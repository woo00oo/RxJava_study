package com.study.rxjava.chapter06;

import com.study.rxjava.utils.DateUtil;
import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 데이터를 1건만 통지하거나 1건도 통지하지 않고 완료 또는 에러를 통지
 *
 */
public class MaybeCreateExample {

    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Throwable {
                emitter.onSuccess(DateUtil.getNowDate());

                emitter.onComplete();
            }
        });

        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // 아무것도 하지 않음
            }

            @Override
            public void onSuccess(@NonNull String data) {
                Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data);
            }

            @Override
            public void onError(@NonNull Throwable error) {
                Logger.log(LogType.ON_ERROR, error);
            }

            @Override
            public void onComplete() {
                Logger.log(LogType.ON_COMPLETE);
            }
        });

    }

}
