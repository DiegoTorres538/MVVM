package com.diegotorres.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.diegotorres.mvvm.R
import com.diegotorres.mvvm.databinding.ActivityDetalleBinding
import com.diegotorres.mvvm.model.Offer
import com.diegotorres.mvvm.viewmodel.DetalleViewModel

class DetalleActivity : AppCompatActivity() {

    private var detalleViewModel:DetalleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?) {

        var activityDetalleBinding:ActivityDetalleBinding = DataBindingUtil.setContentView(this, R.layout.activity_detalle)

        detalleViewModel = ViewModelProvider(this).get(DetalleViewModel::class.java)

        activityDetalleBinding.model = detalleViewModel
        activityDetalleBinding.lifecycleOwner = this

        detalleViewModel?.setDetalleCupon(intent?.getSerializableExtra("cupon") as Offer)
    }
}
