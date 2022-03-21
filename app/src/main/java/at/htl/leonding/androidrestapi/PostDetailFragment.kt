package at.htl.leonding.androidrestapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import at.htl.leonding.androidrestapi.databinding.FragmentPostDetailBinding
import at.htl.leonding.androidrestapi.network.PostViewModel

class PostDetailFragment : Fragment() {

    private lateinit var binding: FragmentPostDetailBinding
    private val postViewModel: PostViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("INFO", postViewModel.currentPost.toString())
        binding = FragmentPostDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.postModel = postViewModel.currentPost
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PostDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
    }
}