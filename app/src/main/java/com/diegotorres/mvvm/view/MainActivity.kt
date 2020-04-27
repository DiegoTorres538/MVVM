package com.diegotorres.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegotorres.mvvm.R
import com.diegotorres.mvvm.databinding.ActivityMainBinding
import com.diegotorres.mvvm.model.ApiService
import com.diegotorres.mvvm.model.Cupones
import com.diegotorres.mvvm.model.Offer
import com.diegotorres.mvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mainViewModel:MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?) {
        var activityMainBinding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        activityMainBinding.model = mainViewModel
        activityMainBinding.lifecycleOwner = this
        setUpListUpdate()
    }

    fun setUpListUpdate() {
        mainViewModel?.callCupones()
        mainViewModel?.getCupones()?.observe(this, Observer {
            Log.d("Cupon",it[0].title)
            mainViewModel?.setCuponInCuponesAdaptar(it)
        })

        setUpListClick()
    }

    fun setUpListClick() {
        mainViewModel?.getCuponSelected()?.observe(this, Observer {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("cupon",it)
        startActivity(intent)})
    }
}
