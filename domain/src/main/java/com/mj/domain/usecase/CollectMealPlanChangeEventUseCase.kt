package com.mj.domain.usecase

import com.mj.firebase.FirebaseRepository
import javax.inject.Inject

class CollectMealPlanChangeEventUseCase @Inject constructor(
    firebase: FirebaseRepository
){
    val getMealPlanChangeEventFlow = firebase.getMealPlanEventFlow()
}