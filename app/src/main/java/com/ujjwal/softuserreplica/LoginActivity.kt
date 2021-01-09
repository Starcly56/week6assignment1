package com.ujjwal.softuserreplica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUsername= findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLoginAction()
    }
    private fun btnLoginAction(){
        btnLogin.setOnClickListener {
            if (inputFieldValidation()) {
                if (etUsername.text.toString() == "softwarica" && etPassword.text.toString() == "coventry") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                return@setOnClickListener
            }
        }
    }
    private fun inputFieldValidation():Boolean{
        var valid = true
        if (TextUtils.isEmpty(etUsername.text.toString())){
            etUsername.error="Username cannot be Empty"
            etUsername.requestFocus()
            valid=false
        }
        else if (TextUtils.isEmpty(etPassword.text.toString())){
            etPassword.error="Password cannot be Empty"
            etPassword.requestFocus()
            valid=false
        }
        return valid
    }
}