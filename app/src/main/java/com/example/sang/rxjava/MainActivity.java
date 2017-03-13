package com.example.sang.rxjava;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindColor;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @BindColor(R.color.grey) protected int GREY;
    @BindColor(R.color.green) protected int GREEN;
    @BindColor(R.color.red) protected int RED;
    @BindColor(R.color.blue) protected int BLUE;
    @BindColor(R.color.white) protected int WHITE;

    rxjava_simple1 rx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        rx = new rxjava_simple1();

        rx.setinit(BLUE, findViewById(R.id.imblue));
        rx.setinit(GREY, findViewById(R.id.imgrey));
        rx.setinit(GREY, findViewById(R.id.imgrey2));
        rx.setinit(GREEN, findViewById(R.id.imgreen));
        rx.setinit(RED, findViewById(R.id.imred));
        rx.setsub();

    }
}

