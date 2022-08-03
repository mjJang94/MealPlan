package com.mj.domain.usecase

import com.mj.firebase.FirebaseRepository
import com.mj.firebase.model.MealPlan
import timber.log.Timber
import javax.inject.Inject

class WriteMealPlanUseCase @Inject constructor(
    private val firebase: FirebaseRepository
) {
    suspend fun sendMealPlan(mealPlan: MealPlan) = firebase.sendMealPlan(mealPlan)

}