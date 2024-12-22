import androidx.recyclerview.widget.DiffUtil

// UserDiffCallback helps to optimize RecyclerView item changes
class UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id  // Check if two items are the same (based on unique ID)
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem  // Check if the contents of the two items are identical
    }
}
