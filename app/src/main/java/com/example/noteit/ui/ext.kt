package com.example.noteit.ui

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage (img: String){
    Glide.with(this).load(img).into(this)
}
