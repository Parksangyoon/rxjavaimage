package com.example.sang.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import butterknife.BindColor;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    ImageView imred,imblue;

    @BindColor(R.color.grey) protected int GREY;
    @BindColor(R.color.green) protected int GREEN;
    @BindColor(R.color.red) protected int RED;
    @BindColor(R.color.blue) protected int BLUE;
    @BindColor(R.color.white) protected int WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        imgdata picture = new imgdata();
        imgdata current = new imgdata();


        Picasso.with(this).load(R.drawable.ic_repeat_white_24dp).transform(new ColorFilterTransformation(WHITE)).into((ImageView)findViewById(R.id.imblue));

        Observable<imgdata> im1 = RxView.clicks(findViewById(R.id.imblue)) //RxView 를 쓰기 위해선 compile 'com.jakewharton.rxbinding:rxbinding:0.3.0'
                .map(event -> picture.setdata(R.drawable.ic_repeat_white_24dp,BLUE,(ImageView)findViewById(R.id.imblue)));
        Observable<imgdata> im2 = RxView.clicks(findViewById(R.id.imgrey))
                .map(event -> picture.setdata(R.drawable.ic_mic_white_24dp,GREY,(ImageView)findViewById(R.id.imgrey)));
        Observable<imgdata> im3 = RxView.clicks(findViewById(R.id.imgrey2))
                .map(event -> picture.setdata(R.drawable.ic_check_white_24dp,GREY,(ImageView)findViewById(R.id.imgrey2)));
        Observable<imgdata> im4 = RxView.clicks(findViewById(R.id.imgreen))
                .map(event -> picture.setdata(R.drawable.ic_play_arrow_white_24dp,GREEN,(ImageView)findViewById(R.id.imgreen)));
        Observable<imgdata> im5 = RxView.clicks(findViewById(R.id.imred))
                .map(event -> picture.setdata(R.drawable.ic_pause_white_24dp,RED,(ImageView)findViewById(R.id.imred)));

        Observable<imgdata> together = Observable.merge(im1, im2,im3,im4,im5);

//        together.subscribe(data ->
  //              Picasso.with(this).load(data.draw).transform(new ColorFilterTransformation(data.color)).into(data.im));
        together.subscribe(new Action1<imgdata>() {
            @Override
            public void call(imgdata data) {
                if(current.draw != -99)
                Picasso.with(MainActivity.this).load(current.draw).transform(new ColorFilterTransformation(WHITE)).into(current.im);
                current.setdata(data.draw,data.color,data.im);
                Picasso.with(MainActivity.this).load(data.draw).transform(new ColorFilterTransformation(data.color)).into(data.im);
            }
        });
    }
}
class imgdata{
    int draw;
    int color;
    ImageView im;
    public imgdata(){
        draw=-99;
    }
    public imgdata setdata(int draw, int color, ImageView im){
        this.draw=draw;
        this.color=color;
        this.im=im;
        return this;
    }
    public imgdata getdata(){
        return this;
    }
}
