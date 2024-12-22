package com.example.machinetestfinal
import User
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.machinetestfinal.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the User object passed from the Intent
        val user: User? = intent.getParcelableExtra("user")

        // Check if user data is available and display it
        user?.let {
            binding.apply {
                firstname.text = it.firstname
                lastname.text = it.lastname
                username.text = it.username
                email.text = it.email
                address.text = "${it.address.street}, ${it.address.city}, ${it.address.zipcode}"
                geo.text = "Lat: ${it.address.geo.lat}, Long: ${it.address.geo.long}"
            }
        }
    }
}
