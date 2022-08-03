package com.mj.family_meal_planner.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mj.domain.usecase.CollectMealPlanChangeEventUseCase
import com.mj.domain.usecase.WriteMealPlanUseCase
import com.mj.firebase.model.MealPlan
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainViewModel @Inject constructor(
    private val writeMealPlanUseCase: WriteMealPlanUseCase,
    private val mealPlanChangedEventUseCase: CollectMealPlanChangeEventUseCase
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

    val eventFlow = mealPlanChangedEventUseCase.getMealPlanChangeEventFlow

    fun upload() {
        launch(Dispatchers.IO) {
            writeMealPlanUseCase.sendMealPlan(MealPlan(listOf(MealPlan.Meal("스파게티래", listOf(MealPlan.Meal.SideDish("사이드는 뭐먹지")), "가격이네", "음", 10000L))))
                .addOnSuccessListener {
                    Timber.d("upload success")
                }
                .addOnFailureListener {
                    Timber.e("upload fail by $it")
                }
        }
    }
}