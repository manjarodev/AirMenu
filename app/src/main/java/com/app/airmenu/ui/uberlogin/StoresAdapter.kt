package com.app.airmenu.ui.uberlogin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.airmenu.R
import com.app.airmenu.network.response.UberStores
import com.app.airmenu.utils.SocketState
import com.bumptech.glide.Glide

class StoresAdapter(context_:Context,storesList:List<UberStores.Store>):
    RecyclerView.Adapter<StoresAdapter.ViewHolder>() {
    var onStoreClick: ((UberStores.Store) -> Unit)? = null
    var context:Context
    var list:List<UberStores.Store>

    init {
        context = context_
        list = storesList
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var storeName:TextView
    var storeAddress:TextView
    var storeCountry:TextView
    var storeStatus:TextView
    var storeImage:ImageView

    init {
        storeName = itemView.findViewById(R.id.store_name)
        storeAddress = itemView.findViewById(R.id.store_address)
        storeCountry = itemView.findViewById(R.id.store_country)
        storeStatus = itemView.findViewById(R.id.store_status)
        storeImage = itemView.findViewById(R.id.store_image)

        itemView.setOnClickListener {
            onStoreClick?.invoke(list.get(adapterPosition))
        }
    }
        fun bind(store: UberStores.Store) {
            storeName.text = store.name
            storeAddress.text = store.location.address
            storeCountry.text = store.location.country
            storeStatus.text = store.status

            Glide.with(context).load(store.rawHeroUrl).placeholder(R.drawable.shop).into(storeImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.store_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}