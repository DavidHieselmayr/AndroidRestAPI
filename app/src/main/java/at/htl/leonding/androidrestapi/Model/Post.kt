package at.htl.leonding.androidrestapi.Model

import java.util.*

data class Post(val id: String, val date: String, val title: Rendered, val content: Rendered) {
}