package mobyme.reddit.data.api

import mobyme.reddit.data.model.entity.RedditImage
import mobyme.reddit.data.model.json.JsonRedditImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditService {

    @GET("{search}/top.json")
    suspend fun getImages(@Path("search") search: String): Response<ResultResponse<GenericListResponse<RedditImage>>>

}