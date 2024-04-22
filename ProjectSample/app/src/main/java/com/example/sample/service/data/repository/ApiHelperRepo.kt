package com.example.sample.service.data.repository

import com.example.sample.service.data.network.ApiService
import javax.inject.Inject

/**
 * Repository class for handling API operations related to images.
 * This class interacts with the ApiService to fetch all data.
 */
class ApiHelperRepo @Inject constructor(
    private val apiHelper: ApiService
) {

    /**
     * Suspended function to fetch data from the API.
     * @return A Retrofit Response containing data.
     */
    suspend fun imgValues() = apiHelper.getData(100)
}