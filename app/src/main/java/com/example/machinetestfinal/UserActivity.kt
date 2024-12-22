package com.example.machinetestfinal
import UserAdapter
import UserViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.machinetestfinal.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UserAdapter { user ->
            val intent = Intent(this, UserDetailsActivity::class.java).apply {
                putExtra("user", user) // Passing the User object
            }
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        userViewModel.userList.observe(this) { users ->
            adapter.submitList(users)
        }

        userViewModel.fetchUsers()
    }
}
