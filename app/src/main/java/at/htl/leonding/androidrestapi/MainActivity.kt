package at.htl.leonding.androidrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import at.htl.leonding.androidrestapi.network.PostViewModel


class MainActivity : AppCompatActivity() {
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel.posts.observe(this, {
            it.forEach {
                print(it.title)
                Log.d("forEach it", it.title.rendered)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}