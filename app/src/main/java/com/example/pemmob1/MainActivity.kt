package com.example.pemmob1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pemmob1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)

		setContentView(binding.root)
		initNavigation()
	}

	private fun initNavigation(){
		binding.btnToPage2.setOnClickListener {
			startActivity(Intent(this, Halaman2Activity::class.java))
		}
	}
}
