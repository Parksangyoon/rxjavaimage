package com.example.sang.rxjava;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindColor;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import rx.Observable;
import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sang on 2017-03-12.
 */

public class rxjava_simple1 {
    imgdata picture = new imgdata();
    imgdata current = new imgdata();

    @BindColor(R.color.white) protected int WHITE;


    ArrayList<Observable<imgdata>> imlist = new ArrayList<>();


    public void setinit(int color,View v) {
        imlist.add(RxView.clicks(v)
                .map(event -> picture.setdata(color,(ImageView)v)));
    }

    public void setsub(){
        Observable<imgdata> together = Observable.merge(imlist.get(0), imlist.get(1),imlist.get(2),imlist.get(3)
                ,imlist.get(4));

        together.subscribe(data -> {
            if(current.color != -99)
                (current.im).setColorFilter(WHITE);
            current.setdata(data.color,data.im);
            (picture.im).setColorFilter(picture.color);}
        );

    }
}
