package at.htl.leonding.androidrestapi.overview

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import at.htl.leonding.androidrestapi.R
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import at.htl.leonding.androidrestapi.databinding.PostItemBinding
import at.htl.leonding.androidrestapi.model.Post
import at.htl.leonding.androidrestapi.network.PostViewModel


class PostsAdapter(private val postViewModel: PostViewModel) : ListAdapter<Post,
        PostsAdapter.PostViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.PostViewHolder {
        return PostViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: PostsAdapter.PostViewHolder, position: Int) {
        val post = getItem(position)
        Log.d("Posts-Adapter", "Post: " + post.toString() + "onBindViewHolder")
        Log.d("Posts-Adapter", "Itemview: " + holder.itemView.toString() + "onBindViewHolder")

        holder.itemView.setOnClickListener {
            postViewModel.currentPost = post
            it.findNavController().navigate(R.id.action_postOverviewFragment_to_postDetailFragment)
        }
        // SetOnTouchListener ermöglicht setOnClickListener auf WebView
        holder.itemView.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> v.performClick()
            }
            v?.onTouchEvent(event) ?: true
        }
        holder.bind(post)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(
            oldItem: Post,
            newItem: Post
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Post,
            newItem: Post
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class PostViewHolder(
        private var binding:
        PostItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(p: Post) {
            binding.post = p
            binding.executePendingBindings()
        }
    }


}