package com.diegotorres.mvvm.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegotorres.mvvm.model.Offer
import com.squareup.picasso.Picasso

class DetalleViewModel:ViewModel() {
    private var cupon: MutableLiveData<Offer> = MutableLiveData()

    fun setDetalleCupon(cupon:Offer) {
        this.cupon.value = cupon
    }

    fun getCupon() = cupon

    companion object {
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView, imageUrl: String) {
            if(!imageUrl.isNullOrEmpty()){
                Picasso.get().load(imageUrl).into(imageView)
            }
        }

    }
}