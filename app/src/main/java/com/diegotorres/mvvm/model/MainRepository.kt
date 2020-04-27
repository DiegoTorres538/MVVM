package com.diegotorres.mvvm.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository:IMainRepository{

    private var cupones = MutableLiveData<List<Offer>>()

    override fun getCupones():MutableLiveData<List<Offer>>{
        return cupones
    }

    override fun callCuponesApi() {
        val apiKey = "1fb8ac7ca6031d934faa5f3f1098cd99"
        var cuponList:ArrayList<Offer>? = ArrayList()
        ApiService.create()
            .getCuponStore(apiKey)
            .enqueue(object: Callback<Cupones>{
                override fun onFailure(call: Call<Cupones>, t: Throwable) {
                    Log.e("error:",t.message)
                }

                override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                    if(response.isSuccessful){
                        cuponList= response.body()?.offers as ArrayList<Offer>
                    }
                    cupones.value = cuponList
                }

            })
    }
}