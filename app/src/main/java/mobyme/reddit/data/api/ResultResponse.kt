package mobyme.reddit.data.api

data class ResultResponse<T>(
    val kind: String? = "",
    val data: T? = null
)