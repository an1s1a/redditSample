package mobyme.reddit.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "reddit_image")
data class RedditImage (
    @PrimaryKey(autoGenerate = true) @NonNull
    var id: Long,
    @SerializedName("id")
    var idString: String,
    var title: String,
    var author: String,
    @SerializedName("created_utc")
    var created: Long,
    var thumbnail: String,
    var preview: Preview,
    var favorite: Boolean
)