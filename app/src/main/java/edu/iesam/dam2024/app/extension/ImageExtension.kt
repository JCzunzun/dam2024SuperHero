package edu.iesam.dam2024.app.extension

import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide

fun ImageView.loadImage(url:String){
    this.load(url)
}
fun ImageView.loadUrl(url: String){
    Glide
        .with(this)
        .load(url)
        .into(this)
}