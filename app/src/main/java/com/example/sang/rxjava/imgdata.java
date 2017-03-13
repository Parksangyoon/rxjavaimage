package com.example.sang.rxjava;

import android.widget.ImageView;

/**
 * Created by sangyoonpark on 2017. 3. 13..
 */

public class imgdata{
    int color;
    ImageView im;
    public imgdata(){
        color=-99;
    }
    public imgdata setdata(int color, ImageView im){
        this.color=color;
        this.im=im;
        return this;
    }
}