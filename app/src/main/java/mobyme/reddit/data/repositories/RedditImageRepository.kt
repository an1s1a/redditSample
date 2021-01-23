package mobyme.reddit.data.repositories

import mobyme.reddit.data.dao.RedditImageDao
import mobyme.reddit.data.remotedatasource.RedditImageRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RedditImageRepository @Inject constructor(private val dao: RedditImageDao, private val remoteDataSource: RedditImageRemoteDataSource) {

    suspend fun getImages(inputSearch: String) = remoteDataSource.getImages(inputSearch)
}