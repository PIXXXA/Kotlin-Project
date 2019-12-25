package com.firsttask.itransition.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImage(view:ImageView , url : String){
    Picasso.with(view.context)
            .load(url)
            .into(view)
}