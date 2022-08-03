package com.mj.domain.usecase

import com.mj.firebase.FirebaseRepository
import javax.inject.Inject

class CollectMealPlanChangeEventUseCase @Inject constructor(
    firebase: FirebaseRepository
){
    val mealPlanChangeEventStream = firebase.mealPlanEventStream
}