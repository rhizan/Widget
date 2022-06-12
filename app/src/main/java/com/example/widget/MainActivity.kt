package com.example.widget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widget.databinding.ActivityMainBinding
import com.example.widget.databinding.ActivityWidgetBinding

// MEMBUAT VARIABEL BINDING
private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INISIALISASI BINDING
        binding = ActivityMainBinding.inflate(layoutInflater)
        // MEMANGGGIL LAYOUT DENGAN MENGGUNAKAN BINDING.ROOT
        setContentView(binding.root)

        // MENGAMBIL DATA YANG DI INPUT DI LOGIN ACTIVITY
        val getData = intent.getParcelableExtra<ModelLogin>("data")
        binding.txtUsername.text = getData?.username.toString()
        binding.txtPassword.text = getData?.password.toString()

        // EXPLICIT INTENT PEMANNGILAN KELAS DALAM SATU PROJEK
        binding.btnIntentWidget.setOnClickListener {
            val intent = Intent(this, Widget::class.java)
            startActivity(intent)
        }

        binding.btnIntentExplicit.setOnClickListener {
            val intent = Intent(this, ImplicitIntent::class.java)
            startActivity(intent)
        }

    }
}