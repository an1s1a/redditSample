package mobyme.reddit.data.model.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "reddit_image")
data class RedditImage @Ignore constructor(
    @PrimaryKey(autoGenerate = true) @NonNull
    var idTable: Long,
    var id: String,
    var title: String,
    var author: String,
    @SerializedName("created_utc")
    var created: Long,
    var thumbnail: String,
    var originalUrl: String,
    var originalWidth: Int,
    var originalHeight: Int,
    var favorite: Boolean,
    @Ignore
    var preview: Preview?
) {
    constructor(
        idTable: Long,
        id: String,
        title: String,
        author: String,
        created: Long,
        thumbnail: String,
        originalUrl: String,
        originalWidth: Int,
        originalHeight: Int,
        favorite: Boolean
    ) :
            this(
                idTable,
                id,
                title,
                author,
                created,
                thumbnail,
                originalUrl,
                originalWidth,
                originalHeight,
                favorite,
                null
            )
}