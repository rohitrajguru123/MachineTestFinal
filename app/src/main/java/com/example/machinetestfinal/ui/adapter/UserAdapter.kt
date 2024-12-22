import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.machinetestfinal.databinding.ItemUserBinding

// Define the UserAdapter class
class UserAdapter(private val onItemClick: (User) -> Unit) : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    // ViewHolder for binding each user data to the views
    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        // Function to bind user data to the views
        fun bind(user: User) {
            // Bind data to respective views in the layout
            binding.firstname.text = user.firstname
            binding.lastname.text = user.lastname
            binding.username.text = user.username
            binding.email.text = user.email

            // Handle item click event
            itemView.setOnClickListener {
                onItemClick(user)  // Pass the clicked user data
            }
        }
    }

    // Inflate the layout and return the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    // Bind the data to the ViewHolder
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position)) // Get the user at the given position
    }
}
