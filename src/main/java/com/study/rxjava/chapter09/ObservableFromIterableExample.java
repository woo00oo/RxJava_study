package com.study.rxjava.chapter09;

import com.study.rxjava.utils.LogType;
import com.study.rxjava.utils.Logger;
import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableFromIterableExample {

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Korea", "Canada", "USA", "Italy");

        Observable.fromIterable(countries)
                .subscribe(country -> Logger.log(LogType.ON_NEXT, country));

    }

}
