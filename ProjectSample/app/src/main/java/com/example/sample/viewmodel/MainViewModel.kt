package com.example.sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample.service.data.APIModel
import com.example.sample.service.data.repository.ApiHelperRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * ViewModel class for handling main screen data and operations.
 * This ViewModel communicates with the repository to fetch data.
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val apiHelperRepo: ApiHelperRepo) : ViewModel() {

    // LiveData to hold the fetched data
    val imageValues = MutableLiveData<APIModel?>()

    /**
     * Function to request  data from the repository.
     * The function launches a coroutine in the IO dispatcher to perform the network request.
     */
    fun request() {
        viewModelScope.launch {
            // Perform API call in IO dispatcher
            val res = withContext(Dispatchers.IO) { apiHelperRepo.imgValues() }

            // Handle the response based on the HTTP status code
            when (res.code()) {
                200 -> {
                    // Handle a successful response with a status code of 200
                    imageValues.postValue(res.body())
                }
                else -> {
                    // Handle other response codes
                    val data: APIModel? = null
                    imageValues.postValue(data)
                }
            }
        }
    }
}