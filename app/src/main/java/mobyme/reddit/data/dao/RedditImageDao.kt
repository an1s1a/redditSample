package mobyme.reddit.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mobyme.reddit.data.model.entity.RedditImage

@Dao
interface RedditImageDao {

    @Query("SELECT * FROM reddit_image")
    fun getImages(): LiveData<List<RedditImage>>

    @Query("SELECT * FROM reddit_image WHERE id = :id")
    fun getImagebyId(id: Long): LiveData<RedditImage>

    @Query("SELECT * FROM reddit_image WHERE favorite IS 'TRUE'")
    fun getFavoriteImages(): LiveData<List<RedditImage>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(images: List<RedditImage>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(images: RedditImage)
}