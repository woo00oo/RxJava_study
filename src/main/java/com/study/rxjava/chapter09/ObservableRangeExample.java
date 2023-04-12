package com.study.rxjava.chapter09;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

/**
 * 반복문으로 사용 가능
 *
 */
public class ObservableRangeExample {

    public static void main(String[] args) {
        Observable.range(0, 5)
                .subscribe(num -> Logger.log(LogType.ON_NEXT, num));
    }

}
