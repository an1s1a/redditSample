package mobyme.reddit.data.remotedatasource

import mobyme.reddit.data.BaseDataSource
import mobyme.reddit.data.api.RedditService
import javax.inject.Inject

class RedditImageRemoteDataSource @Inject constructor(private val service: RedditService) :
    BaseDataSource() {

    suspend fun getImages(inputSearch: String) = getResult { service.getImages(inputSearch) }
}