package com.example.multi_moduleapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.coroutineScope
import com.example.multi_moduleapp.databinding.ActivityMainBinding
import com.example.presentation.blog_post.BlogViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    private val viewModel : BlogViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)


        //viewModel.getBlog()

        getBlog()


    }

    private fun getBlog() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.blogList.collect {

                if (it.isLoading) {

                    binding!!.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {

                    binding!!.progressBar.visibility = View.GONE
                }

                it.data?.let {

                    if (it.isEmpty()) {
                        binding!!.progressBar.visibility = View.VISIBLE
                    }

                    Log.d("ListSize", "list size"+ it.toString())
                    Toast.makeText(this@MainActivity,"size "+ it.size.toString(), Toast.LENGTH_LONG).show()
                    binding!!.progressBar.visibility = View.GONE

                }
            }
        }
    }
}