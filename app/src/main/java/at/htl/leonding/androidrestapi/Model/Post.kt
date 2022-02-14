package at.htl.leonding.androidrestapi.Model

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
@RequiresApi(Build.VERSION_CODES.O)
data class Post(val id: String, val date: String, val title: Rendered, val content: Rendered) {
}