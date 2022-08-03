package com.mj.firebase.model

// Null default values create a no-argument default constructor, which is needed
// for deserialization from a DataSnapshot.

data class MealPlan(
    val morningPlan: List<Meal>?= null,
    var lunchPlan: List<Meal>?= null,
    var dinnerPlan: List<Meal>?= null,
){
    data class Meal(
        val mainDish: String ?= null,
        val side: List<SideDish> ?= null,
        val price: String ?= null,
        val comment: String ?= null,
        val time: Long ?= 0L
    ){
        data class SideDish(
            val name: String ?= null
        )
    }
}
