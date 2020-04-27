package com.diegotorres.mvvm.model

import androidx.lifecycle.MutableLiveData

interface IMainRepository {
    fun callCuponesApi()
    fun getCupones():MutableLiveData<List<Offer>>
}