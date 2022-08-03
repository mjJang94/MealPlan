package com.mj.firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.mj.firebase.model.MealPlan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    private val databaseReference: DatabaseReference
) {
    sealed interface Event {
        data class Error(val error: DatabaseError) : Event
        data class DataChanged(val snapshot: MealPlan?) : Event
    }

    val mealPlanEventStream = callbackFlow {
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Timber.d("onDataChange()")
                trySend(Event.DataChanged(snapshot.getValue<MealPlan>()))
            }

            override fun onCancelled(error: DatabaseError) {
                Timber.d("onCancelled()")
                trySend(Event.Error(error))
            }
        }
        databaseReference.addValueEventListener(valueEventListener)

        awaitClose {
            Timber.e("awaitClose")
            databaseReference.removeEventListener(valueEventListener)
        }
    }

    suspend fun sendMealPlan(mealPlan: MealPlan) = withContext(Dispatchers.Unconfined){
        Timber.d("sendMealPlan launch on ${Thread.currentThread().name}")
        databaseReference.setValue(mealPlan)
    }
}