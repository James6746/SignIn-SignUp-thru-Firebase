package com.example.firebase.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog

open class BaseActivity : AppCompatActivity(){
    lateinit var context: Context
    var progressDialog: AppCompatDialog? = null

    fun callMainActivity(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun callSignInActivity(context: Context){
        val intent = Intent(context, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}