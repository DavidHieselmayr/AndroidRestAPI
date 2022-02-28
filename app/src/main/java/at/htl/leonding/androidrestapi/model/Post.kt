package at.htl.leonding.androidrestapi.model

//@RequiresApi(Build.VERSION_CODES.O)
data class Post(val id: Int, val date: String, val title: Rendered, val content: Rendered) {
}