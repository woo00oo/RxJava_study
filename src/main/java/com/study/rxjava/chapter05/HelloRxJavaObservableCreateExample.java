package com.study.rxjava.chapter05;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HelloRxJavaObservableCreateExample {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable =
                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                        String[] datas = {"Hello", "RxJava!"};
                        for (String data : datas) {
                            if (emitter.isDisposed()) return;

                            emitter.onNext(data);
                        }
                        emitter.onComplete();
                    }
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        // 아무 처리도 하지 않음
                    }

                    @Override
                    public void onNext(@NonNull String data) {
                        Logger.log(LogType.ON_NEXT, data);
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

        Thread.sleep(500L);

    }

}
