package at.htl.leonding.androidrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import at.htl.leonding.androidrestapi.Network.PostViewModel


class MainActivity : AppCompatActivity() {
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel.posts.value?.forEach { print(it.title) }
    }
}