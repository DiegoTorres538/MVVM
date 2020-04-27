package com.diegotorres.mvvm.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegotorres.mvvm.model.MainObservable
import com.diegotorres.mvvm.model.Offer
import com.diegotorres.mvvm.view.CuponesAdapter
import com.squareup.picasso.Picasso

class MainViewModel:ViewModel(){

    private var mainObservable:MainObservable = MainObservable()
    private var cuponesAdapter:CuponesAdapter? = null
    private var cuponSelected:MutableLiveData<Offer> = MutableLiveData()

    fun callCupones(){
        mainObservable.callCupones()
    }

    fun getCupones():MutableLiveData<List<Offer>>{
        return mainObservable.getCupones()
    }

    fun setCuponInCuponesAdaptar(cupones:List<Offer>){
        cuponesAdapter?.setCuponesList(cupones)
        cuponesAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCuponesAdapter():CuponesAdapter?{
        cuponesAdapter = CuponesAdapter(this)
        return cuponesAdapter
    }

    fun getCuponAt(position:Int):Offer?{
        var cupon:List<Offer>? = mainObservable.getCupones().value
        return cupon?.get(position)
    }

    fun getCuponSelected():MutableLiveData<Offer>{
        return cuponSelected
    }

    fun onItemClick(position: Int){
        val cupon=getCuponAt(position)
        cuponSelected.value = cupon
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl:String){
            if(!imageUrl.isNullOrEmpty()){
                Picasso.get().load(imageUrl).into(imageView)
            }
        }
    }
}