package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.dicodingandroid.R
import com.example.dicodingandroid.databinding.ActivityMainViewModelBinding

class MainActivityViewModel : AppCompatActivity() {

    private lateinit var activityMainViewModelBinding: ActivityMainViewModelBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainViewModelBinding = ActivityMainViewModelBinding.inflate(layoutInflater)
        setContentView(activityMainViewModelBinding.root)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        activityMainViewModelBinding.btnCalculate.setOnClickListener{

            val width = activityMainViewModelBinding.edtWidth.text.toString()
            val height = activityMainViewModelBinding.edtHeight.text.toString()
            val length = activityMainViewModelBinding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    activityMainViewModelBinding.edtWidth.error = "Masih kosong"
                }
                height.isEmpty() -> {
                    activityMainViewModelBinding.edtHeight.error = "Masih kosong"
                }
                length.isEmpty() -> {
                    activityMainViewModelBinding.edtLength.error = "Masih kosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult(){
        activityMainViewModelBinding.tvResult.text = viewModel.result.toString()
    }
}