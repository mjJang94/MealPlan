package com.mj.family_meal_planner.ui

import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mj.family_meal_planner.R
import com.mj.family_meal_planner.base.BaseActivity
import com.mj.family_meal_planner.databinding.ActivityMainBinding
import com.mj.family_meal_planner.ui.MainViewModel.*
import com.mj.firebase.FirebaseRepository.FirebaseEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun initOnCreate() {

        binding.vm = viewModel

        repeatOnCreated {
            viewModel.firebaseEventFlow.collect { event ->
                handleFirebaseEvent(event)
            }
        }

        repeatOnStarted {
            viewModel.eventFlow.collect { event ->
                handleUIEvent(event)
            }
        }
    }

    private fun handleFirebaseEvent(event: FirebaseEvent) = when (event) {
        is FirebaseEvent.DataChanged -> {
            Timber.d("data changed : ${event.snapshot}")
        }

        is FirebaseEvent.Error -> {
            Timber.d("error with ${event.error}")
        }
    }

    private fun handleUIEvent(event: UIEvent) = when (event) {
        is UIEvent.ShowToast -> {
            Timber.d("Show Toast : ${event.text}")
        }
        is UIEvent.UploadClick -> {
            viewModel.upload()
        }
    }

    //TODO : LifecycleOwner extension functions must be in util package

    fun LifecycleOwner.repeatOnCreated(block: suspend CoroutineScope.() -> Unit) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED, block)
        }
    }

    fun LifecycleOwner.repeatOnStarted(block: suspend CoroutineScope.() -> Unit) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED, block)
        }
    }
}