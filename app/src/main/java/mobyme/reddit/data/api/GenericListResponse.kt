package mobyme.reddit.data.api

data class GenericListResponse<T> (
    val children: List<ResultResponse<T>>? = listOf()
)