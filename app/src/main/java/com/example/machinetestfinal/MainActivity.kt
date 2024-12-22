package com.example.machinetestfinal
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.machinetestfinal.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object to access views
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set an OnClickListener for the button to navigate to UserActivity
        binding.buttonNavigate.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
    }
}
