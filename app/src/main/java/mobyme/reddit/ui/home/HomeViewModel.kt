package mobyme.reddit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import mobyme.reddit.data.api.GenericListResponse
import mobyme.reddit.data.model.entity.RedditImage
import mobyme.reddit.data.repositories.RedditImageRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: RedditImageRepository
) : ViewModel() {

    private val _imageList = MutableLiveData<GenericListResponse<RedditImage>>()
    val imageList: LiveData<GenericListResponse<RedditImage>>
        get() = _imageList

    fun getImages(searchInput: String) = liveData(Dispatchers.IO) {
        val retrievedImages = repository.getImages(searchInput)

        _imageList.postValue(retrievedImages.data?.data)
        emit(retrievedImages)
    }

}