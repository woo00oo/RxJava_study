package com.study.rxjava.chapter10;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableSkipExample01 {

    public static void main(String[] args) {
        Observable.range(1, 15)
                .skip(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}
