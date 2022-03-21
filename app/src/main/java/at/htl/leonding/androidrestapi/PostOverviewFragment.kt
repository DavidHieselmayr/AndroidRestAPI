package at.htl.leonding.androidrestapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import at.htl.leonding.androidrestapi.databinding.FragmentPostOverviewBinding
import at.htl.leonding.androidrestapi.model.Post
import at.htl.leonding.androidrestapi.network.PostViewModel
import at.htl.leonding.androidrestapi.overview.PostsAdapter


class PostOverviewFragment : Fragment() {
    private lateinit var binding : FragmentPostOverviewBinding
    private val postViewModel: PostViewModel by activityViewModels()
    /*private val viewModel: PostViewModel by lazy {
        ViewModelProvider(this).get(PostViewModel::class.java)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
/*
    fun updatePosts(posts : MutableList<Post>) {
        val adapter : PostsAdapter? = context?.let { PostsAdapter(it, android.R.layout.simple_list_item_1, android.R.id.text1, posts) }
        binding.postsRV.adapter = adapter
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.postsRV.adapter = PostsAdapter(postViewModel)
        binding.viewModel = postViewModel
        // Inflate the layout for this fragment
        return binding.root
    }
}