package mobyme.reddit.data

import androidx.room.Database
import androidx.room.RoomDatabase
import mobyme.reddit.data.dao.RedditImageDao
import mobyme.reddit.data.model.entity.RedditImage

@Database(entities = arrayOf(RedditImage::class), version = 1)
abstract class RedditDatabase : RoomDatabase() {

    abstract fun redditImageDao(): RedditImageDao
}