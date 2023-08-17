package com.rns.marvelapp.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rns.marvelapp.R
import com.rns.marvelapp.ui.base.BaseAdapter
import com.rns.marvelapp.utils.Constants.RESPONSE_LIMIT

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    if (state is State.Loading) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    if (state is State.Error) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    if (state is State.Success) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:itemsWithLimits"])
fun <T> setItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items?.take(RESPONSE_LIMIT) ?: emptyList())
}

@BindingAdapter(value = ["app:visibilityStatus"])
fun <T> setViewVisibility(view: View, items: List<T>?) {
    if (items.isNullOrEmpty()) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@SuppressLint("CheckResult")
@BindingAdapter(value = ["app:loadImage"])
fun loadImage(imgView: ImageView, url: String?) {
    url?.let {
        imgView.load(url) {
            placeholder(R.drawable.loading_img)
            error(R.drawable.ic_broken_image)
        }
    }
//    url?.let {
//        if (url.contains("image_not_available")) {
//            Glide
//                .with(imgView)
//                .load(R.drawable.loading_animation)
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image)
//                .into(imgView)
//        } else {
//            Glide
//                .with(imgView)
//                .load(url)
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image)
//                .into(imgView)
//        }
//    }
}