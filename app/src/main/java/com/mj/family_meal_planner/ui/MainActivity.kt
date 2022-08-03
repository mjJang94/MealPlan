package com.mj.family_meal_planner.ui

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.firebase.database.ktx.getValue
import com.mj.family_meal_planner.R
import com.mj.family_meal_planner.base.BaseActivity
import com.mj.family_meal_planner.databinding.ActivityMainBinding
import com.mj.firebase.FirebaseRepository.*
import com.mj.firebase.model.MealPlan
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(){

    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun initOnCreate() {

        binding.vm = viewModel

        lifecycleScope.launchWhenCreated {
            viewModel.eventFlow.collectLatest {
                when(it){
                    is Event.DataChanged -> {
                        val data = it.snapshot.getValue<MealPlan>()
                        Timber.d("data changed : $data")
                    }

                    is Event.Error -> {
                        Timber.d("error with ${it.error}")
                    }

                    else -> {
                        Timber.e("not expected error $it")
                    }
                }
            }
        }


        binding.txtTest.setOnClickListener {
            viewModel.upload()
        }
    }
}