package com.app.airmenu.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.airmenu.R
import com.app.airmenu.databinding.ActivityUberOrderNotificationBinding
import com.app.airmenu.room.database.*
import com.app.airmenu.room.model.UberNotification
import com.app.airmenu.session.SessionManager

@Suppress("DEPRECATION")
class UberOrderNotification : AppCompatActivity() {

    private val TAG: String = UberOrderNotification::class.java.simpleName

    private lateinit var binding: ActivityUberOrderNotificationBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var adapter: NotificationAdapter
    private lateinit var viewModel: DatabaseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUberOrderNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initVariables()

    }

    private fun initVariables() {
        viewModel = ViewModelProviders.of(
            this, ViewModelFactory(
                DatabaseHelperImpl(DatabaseBuilder.getInstance(this))
            )
        ).get(DatabaseViewModel::class.java)

        binding.logoutbutton.setOnClickListener {
            onBackPressed()
        }

        getAndDisplayUberNotification()

    }

    private fun getAndDisplayUberNotification() {

        viewModel.getAllNotifications().observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    binding.notificationRecyclerView.visibility = View.GONE
                    binding.noItemFound.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        binding.notificationRecyclerView.visibility = View.VISIBLE
                        binding.noItemFound.visibility = View.GONE

                        binding.totalNotifications.text =
                            "Total received notifications: ${it.data.size}"
                        adapter = NotificationAdapter(it.data, this)
                        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(this)
                        binding.notificationRecyclerView.setHasFixedSize(true)
                        binding.notificationRecyclerView.adapter = adapter

                    } else {
                        binding.notificationRecyclerView.visibility = View.GONE
                        binding.noItemFound.visibility = View.VISIBLE
                        binding.noItemFound.text =
                            "There is some error while getting the notification form database"
                    }
                }
                Status.ERROR -> {
                    binding.notificationRecyclerView.visibility = View.GONE
                    binding.noItemFound.visibility = View.VISIBLE
                }
            }
        })
    }


    inner class NotificationAdapter(data: ArrayList<UberNotification>, _context: Context) :
        RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

        var list: ArrayList<UberNotification>
        var context: Context

        init {
            list = data
            context = _context
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var orderId: TextView
            var storeId: TextView
            var localTime: TextView
            var timemstamp: TextView
            var status: TextView

            init {
                orderId = itemView.findViewById(R.id.order_id)
                storeId = itemView.findViewById(R.id.store_id)
                localTime = itemView.findViewById(R.id.local_time)
                timemstamp = itemView.findViewById(R.id.time_stamp)
                status = itemView.findViewById(R.id.status)
            }

            fun bind(get: UberNotification) {
                orderId.text = get.orderId
                storeId.text = get.storeId
                localTime.text = get.localTime
                timemstamp.text = get.timemstamp
                status.text = get.status
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(context).inflate(R.layout.layout_uber_order, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list.get(position))
        }

        override fun getItemCount(): Int = list.size

    }
}