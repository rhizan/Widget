package com.example.widget

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import com.example.widget.databinding.ActivityImplicitIntentBinding
import com.example.widget.databinding.ActivityWidgetBinding

// MEMBUAT VARIABEL BINDING
private lateinit var binding : ActivityImplicitIntentBinding
class ImplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INISIALISASI BINDING
        binding = ActivityImplicitIntentBinding.inflate(layoutInflater)
        // MEMANGGGIL LAYOUT DENGAN MENGGUNAKAN BINDING.ROOT
        setContentView(binding.root)

        // BUAT PERMISION CAMERA DI IZINKAN ATAU TIDAK NYA DI VERSI ATAS 23
        if (Build.VERSION.SDK_INT >= 23) {
            if(checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    1)
            }

        }

        // PEMANGGILAN BINDING CAMERA
        binding.btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // PEMANGGAILAN FILE
        binding.btnFile.setOnClickListener {
            val intent = Intent()
            intent.type = "*/*"

            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(Intent.createChooser(intent, "Pilih file"), 0)
        }

        // PEMANGGILAN BROWSER
        binding.btnBrowser.setOnClickListener {
            val url = "https://googel.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }



    }
}