package com.sukhralia.gimmeasign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sukhralia.gimmeasign.classification.ClassifierActivity
import com.sukhralia.gimmeasign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        handleUI()
    }

    private fun handleUI(){
        binding.detect.setOnClickListener {
            startActivity(Intent(this,ClassifierActivity::class.java).apply {

            })
        }

        AppSharedPreferences.init(this)

        if(AppSharedPreferences.getUserMode()){
            binding.devMode.isChecked = true
        }

        binding.devMode.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                AppSharedPreferences.setUserMode(true)
            }else{
                AppSharedPreferences.setUserMode(false)
            }
        }
    }
}