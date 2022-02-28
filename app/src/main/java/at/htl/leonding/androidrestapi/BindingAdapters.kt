package at.htl.leonding.androidrestapi

import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import at.htl.leonding.androidrestapi.model.Post
import at.htl.leonding.androidrestapi.overview.PostsAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView : RecyclerView, data : List<Post>?) {
    val adapter = recyclerView.adapter as PostsAdapter
    adapter.submitList(data)
}

@BindingAdapter("htmlString")
fun loadHTML(view: WebView, htmlString: String) {
    if(htmlString.isEmpty()){
        return
    }

    try{
        view.webChromeClient = WebChromeClient()
        view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
            }
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return false
            }
        }

        view.loadData(htmlString, "text/html", "UTF-8")
    }catch (ex: Exception){
        Log.e("BindingAdapter", "Error loading html string")
    }
}