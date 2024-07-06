package com.example.b192

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b192.databinding.ActivityMainBinding
import com.example.b192.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var dialog:AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnClick.setOnClickListener {
            showDialogBinding()
        }
    }

    private fun showDialogBinding() {
        val build = AlertDialog.Builder(this,R.style.Themecustom)
        val dialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(this))
        build.setView(dialogBinding.root)

        dialogBinding.btnclose.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.btnjoin.setOnClickListener {
            Toast.makeText(this, "Joined", Toast.LENGTH_SHORT).show()
        }

        dialog = build.create()
        dialog.show()
    }

    private fun showDialofNormal() {
        val build = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.custom_dialog, null)
        build.setView(view)
        // close code
        val btnclose = view.findViewById<ImageButton>(R.id.btnclose)
        val btnJoin = view.findViewById<Button>(R.id.btnjoin)


        btnclose.setOnClickListener {
            dialog.dismiss()
        }

        // join code
        btnJoin.setOnClickListener {
           Toast.makeText(this, "Joined", Toast.LENGTH_SHORT).show()
        }
        dialog = build.create()
        dialog.show()

    }
}