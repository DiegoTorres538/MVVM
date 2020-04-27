package com.diegotorres.mvvm.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class MainObservable:BaseObservable() {
    private var mainRepository:IMainRepository = MainRepository()

    fun callCupones(){
        mainRepository.callCuponesApi()
    }

    fun getCupones():MutableLiveData<List<Offer>>{
        return mainRepository.getCupones()
    }
}