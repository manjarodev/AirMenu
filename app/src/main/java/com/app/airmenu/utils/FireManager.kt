package com.app.airmenu.utils

import com.google.firebase.firestore.FirebaseFirestore

class FireManager {

//    companion object{
//            val db = FirebaseFirestore.getInstance()
//        val tokenReference = db.collection("settings").document("notification")
//    }
 companion object{
            val db = FirebaseFirestore.getInstance()
        val tokenReference = db.collection("settings1")
    }

}