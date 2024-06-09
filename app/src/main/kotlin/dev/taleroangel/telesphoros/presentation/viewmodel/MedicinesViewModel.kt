package dev.taleroangel.telesphoros.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.taleroangel.telesphoros.domain.model.Medicine
import dev.taleroangel.telesphoros.domain.repository.MedicineRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Keep state of the [Medicine] in the application
 */
class MedicinesViewModel @Inject constructor(
    /**
     * Repository for accessing medicines
     */
    private val medicineRepository: MedicineRepository,

    /**
     * Keep state across configuration changes
     */
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        /**
         * Tag for using with [Log] and [SavedStateHandle]
         */
        val TAG = MedicinesViewModel::class.simpleName!!
    }

    /**
     * Current medicines stored in database
     */
    private val _medicines: MutableLiveData<List<Medicine>> =
        savedStateHandle.getLiveData("$TAG:medicines", listOf())

    /**
     * Public immutable view of [_medicines]
     */
    val medicines: LiveData<List<Medicine>> = _medicines

    /**
     * On initialization, listen to all the medicines in the database and update the state
     */
    init {
        viewModelScope.launch {
            medicineRepository.getAllMedicines().collect { medicines ->
                // Set new value on arrival from database
                Log.d(TAG, "Updated medicines with (${medicines.size}) new values")
                _medicines.value = medicines
            }
        }
    }
}