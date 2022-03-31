package com.example.firebase.activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase.R
import com.example.firebase.managers.AuthHandler
import com.example.firebase.managers.AuthManager
import com.example.firebase.utils.Extensions.toast


class SignInActivity: BaseActivity() {

    val TAG = SignInActivity::class.java.toString()
    lateinit var et_email: EditText
    lateinit var et_password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        initViews()
    }

    fun initViews(){
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        val b_signin = findViewById<Button>(R.id.b_signin)
        b_signin.setOnClickListener { firebaseSignIn(et_email.toString(), et_password.toString()) }
        val tv_signup = findViewById<TextView>(R.id.tv_signup)
        tv_signup.setOnClickListener { callSignUpActivity() }
    }

    fun callSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }


    private fun firebaseSignIn(email: String, password: String){
        AuthManager.signIn(email, password, object : AuthHandler{
            override fun onSuccess() {
                toast("Signed in Successfully")
//                callMainActivity(this@SignInActivity)
                callMainActivity(context)
            }

            override fun onError(exception: Exception?) {
                toast("Sign in Failed")
            }

        })

    }
}