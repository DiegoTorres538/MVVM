package com.diegotorres.mvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.diegotorres.mvvm.BR
import com.diegotorres.mvvm.R
import com.diegotorres.mvvm.model.Offer
import com.diegotorres.mvvm.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cupon_item.view.*

class CuponesAdapter(var mainViewModel: MainViewModel):
    RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>(){

    private var cuponList:List<Offer>? = null

    fun setCuponesList(cupones:List<Offer>){
        this.cuponList = cupones
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponesViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        val binding:ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return CuponesViewHolder(binding)
    }

    override fun getItemCount(): Int = cuponList?.size?:0

    override fun onBindViewHolder(holder: CuponesViewHolder, position: Int) {
        holder.setCupon(mainViewModel,position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.cupon_item
    }

    class CuponesViewHolder(binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root),
    View.OnClickListener{

        private var binding:ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setCupon(mainViewModel: MainViewModel, position: Int) {
            binding?.setVariable(BR.model, mainViewModel)
            binding?.setVariable(BR.position, position)
        }

        override fun onClick(v:View?){

        }
    }
}

