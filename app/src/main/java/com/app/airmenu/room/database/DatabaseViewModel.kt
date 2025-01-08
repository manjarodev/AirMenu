package com.app.airmenu.room.database

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.airmenu.room.model.UberNotification
import kotlinx.coroutines.launch

class DatabaseViewModel(private val dbHleper: DatabaseHelper) : ViewModel() {

    private val TAG: String = DatabaseViewModel::class.java.simpleName

    private val notifications = MutableLiveData<Resource<ArrayList<UberNotification>>>()

    // get All notifications
    fun getAllNotifications(): LiveData<Resource<ArrayList<UberNotification>>> {

        viewModelScope.launch {
            notifications.postValue(Resource.loading(null))

            try {
                val completedfromDB = dbHleper.getAllUberNotification()
                if (completedfromDB.isEmpty()) {
                    notifications.postValue(Resource.error("empty", null))
                } else {
                    notifications.postValue(Resource.success(completedfromDB) as Resource<ArrayList<UberNotification>>?)
                }
            } catch (e: Exception) {
                notifications.postValue(Resource.error("Something Went Wrong", null))
            }
        }

        return notifications
    }

    fun insertUberNotification(uberNotification: UberNotification){
       viewModelScope.launch {
           try {
               dbHleper.insertNewUberNotification(uberNotification)
           }catch (e:Exception){
               Log.e(TAG, "insertUberNotification: error ",e )
           }
       }
    }
}