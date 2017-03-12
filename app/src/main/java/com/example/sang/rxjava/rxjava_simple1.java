package com.example.sang.rxjava;

import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import com.example.sang.*;
/**
 * Created by sang on 2017-03-12.
 */

public class rxjava_simple1 {
    private static final String TAG = MainActivity.class.getName();
    public void rx(){
        Observable<String> simpleObservable =
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello RxAndroid 1234455!!");
                        subscriber.onCompleted();
                    }
                });

        simpleObservable
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String text) {
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                }, new Action0() {
                    @Override
                    public void call() {

                    }
                });

    }

}
