package at.htl.leonding.androidrestapi.overview

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import at.htl.leonding.androidrestapi.databinding.FragmentPostOverviewBinding
import at.htl.leonding.androidrestapi.databinding.PostItemBinding
import at.htl.leonding.androidrestapi.model.Post


class PostsAdapter : ListAdapter<Post,
        PostsAdapter.PostViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(
            LayoutInflater.from(parent.context)))
        Log.d("Posts-Adapter", "oncreateViewHolder")
    }

    override fun onBindViewHolder(holder: PostsAdapter.PostViewHolder, position: Int) {
        val post = getItem(position)
        Log.d("Posts-Adapter", "Post: " + post.toString() + "onBindViewHolder")
        Log.d("Posts-Adapter", "Itemview: " + holder.itemView.toString() + "onBindViewHolder")

        holder.itemView.setOnTouchListener((view, motionEvent) -> {

        })
        holder.bind(post)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post,
                                     newItem: Post): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Post,
                                        newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class PostViewHolder(private var binding:
                                 PostItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(p: Post) {
            binding.post = p
            binding.executePendingBindings()
        }
    }




}