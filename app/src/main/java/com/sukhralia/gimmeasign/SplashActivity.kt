package com.sukhralia.gimmeasign

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.sukhralia.gimmeasign.classification.ClassifierActivity
import com.sukhralia.gimmeasign.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    var i: Int = 0
    val list = ArrayList<Int>()
    var len = 0

    private lateinit var binding : ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)


        binding.logo.background = VectorDrawableCompat.create(resources, R.drawable.ic_monkey_ear, null)

        list.add(R.drawable.ic_monkey_ear)
        list.add(R.drawable.ic_monkey_eye)
        list.add(R.drawable.ic_monkey_mouth)
        list.add(R.drawable.ic_monkey_eye)
        list.add(R.drawable.ic_monkey_ear)

        len = list.size

        changeImage()

    }


    fun changeImage() {
        Handler().postDelayed({
            if (i == len) {
                startActivity(Intent(this@SplashActivity, ClassifierActivity::class.java))
                finish()
            } else {
                binding.logo.background = VectorDrawableCompat.create(resources, list[i], null)
                i++
                changeImage()
            }


        }, 350)
    }


}