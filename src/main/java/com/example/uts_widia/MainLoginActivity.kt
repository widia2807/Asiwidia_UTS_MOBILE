package com.example.uts_widia


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
   private lateinit var edtUname: EditText
   private lateinit var edtPass: EditText
   private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlogin)
        edtUname = findViewById(R.id.editTextTextEmailAddress)
        edtPass = findViewById(R.id.editTextTextPassword)
        btnLogin = findViewById(R.id.button)

        btnLogin.setOnClickListener {
            if (edtUname.text.toString() == ("asiwidia008@gmail.com") && edtPass.text.toString()
                == ("123456789")
            ) {
                val data = getSharedPreferences("Profile", MODE_PRIVATE)
                val edit = data.edit()
                edit.putString("email", "asiwidia008@gmail.com")
                edit.putString("nim", "2207411030")
                edit.putString("nama", "Asiwidia Simanjuntak")
                edit.putString("kelas", "TI 4A")
                edit.putBoolean("isLogin", true)
                edit.apply()

                val pindah = Intent(applicationContext, MainActivity::class.java)
                startActivity(pindah)
                finish()
            }
            else{
                Toast.makeText(applicationContext,"Login Salah", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }

