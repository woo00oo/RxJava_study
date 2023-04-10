package com.study.rxjava.chapter05;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HelloRxJavaObservableCreateLamdaExample {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable =
                Observable.create(emitter -> {
                    String[] datas = {"Hello", "RxJava!"};
                    for(String data : datas){
                        if(emitter.isDisposed())
                            return;

                        emitter.onNext(data);
                    }
                    emitter.onComplete();
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        Thread.sleep(500L);
    }

}
