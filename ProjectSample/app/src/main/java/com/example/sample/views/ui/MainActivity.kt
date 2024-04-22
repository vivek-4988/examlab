package com.example.sample.views.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.gradlesample.R
import com.example.gradlesample.databinding.ActivityMainBinding
import com.example.sample.service.data.APIModel
import com.example.sample.service.data.APIModelItem
import com.example.sample.service.data.repository.ApiHelperRepo
import com.example.sample.utils.Utils
import com.example.sample.utils.isNetworkAvailable
import com.example.sample.utils.lazyViewModel
import com.example.sample.utils.setVisible
import com.example.sample.viewmodel.MainViewModel
import com.example.sample.views.adapter.GridImageAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Main entry point activity of the application.
 * This activity serves as the main screen of the app.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Injected instance of ApiHelperRepo for API operations
    @Inject
    public lateinit var apiHelperRepo: ApiHelperRepo

    // Tag for logging purposes
    val TAG = "main"

    // View binding variable for the activity layout
    lateinit var bind: ActivityMainBinding

    // Lazy-initialized ViewModel instance using lazyViewModel extension function
    val modelCall by lazyViewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set content view using view binding
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Check for network availability before proceeding
        if (isNetworkAvailable()) {
            // Show progress bar while fetching data
            bind.progressBar.setVisible(true)

            // Request  data from the API via ViewModel
            modelCall.request()

            // Observe changes in  data from the ViewModel
            modelCall.imageValues.observe(this) {
                try {
                    // Process the received data
                    val data: APIModel? = it
                    if (data != null) {
                        // Display  data in RecyclerView using adapter
                        bind.recycle.apply {
                            adapter = GridImageAdapter(data, this@MainActivity.lifecycleScope).apply {
                                // Handle item click to navigate to details screen
                                itemClick = { data: APIModelItem, i: Int ->

                                }
                            }
                        }
                        // Hide progress bar after data loading completes
                        bind.progressBar.setVisible(false)
                    } else {
                        // Handle incorrect or null response from API
                        Utils.printMsg("wrong response")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}