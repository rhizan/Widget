package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

// MEMBUAT VARIABEL BINDING
    private lateinit var binding : ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // INISIALISASI BINDING
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        // MEMANGGGIL LAYOUT DENGAN MENGGUNAKAN BINDING.ROOT
        setContentView(binding.root)


        // BUTTON TOAST
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Ini Adalah Toast", Toast.LENGTH_SHORT).show()
        }

        // BUTTON SNACKBAR
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "ini adalah snackbar", Snackbar.LENGTH_SHORT).show()
        }

        // BUTTON ALERT
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("Ini Adalah Alert Rhizan")

                setPositiveButton("OK"){dialog, _ ->
                    Toast.makeText(applicationContext, "Anda Klik OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }

                setNegativeButton("BACK"){dialog, _ ->
                    Toast.makeText(applicationContext, "Anda Klik BACK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }
            }.show()
        }

        // BUTTON CUSTOM DIALOG
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog) // MEMANGGIL KE CUSTOM DIALOG DI LAYOUT

                val btnCancel = this.findViewById<Button>(R.id.btnCancel) // MEMANGGIL BUTTON YANG DI DALEM CUSTOM DIALOG
                val btnContinue = this.findViewById<Button>(R.id.btnContinue) // MEMANGGIL BUTTON YANG DI DALEM CUSTOM DIALOG

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda Klik Cancel", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda Klik Continue", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }


    }
}