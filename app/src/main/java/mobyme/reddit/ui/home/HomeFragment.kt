package mobyme.reddit.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import mobyme.reddit.R
import mobyme.reddit.data.Result
import mobyme.reddit.data.api.GenericListResponse
import mobyme.reddit.data.model.entity.RedditImage
import mobyme.reddit.databinding.FragmentHomeBinding
import mobyme.reddit.ui.BaseFragment
import mobyme.reddit.ui.adapter.RedditImageAdapter
import mobyme.reddit.ui.adapter.RedditImageClickListener
import mobyme.reddit.ui.main.ViewPagerFragmentDirections

class HomeFragment : BaseFragment<HomeViewModel>() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = RedditImageAdapter(RedditImageClickListener { redditImage ->
        val action = ViewPagerFragmentDirections.actionToImageDetail(
            redditImage.thumbnail,
            redditImage.title
        )
        view?.findNavController()?.navigate(action)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val manager = GridLayoutManager(activity, 3)
        binding.imageGrid.layoutManager = manager
        binding.imageGrid.adapter = adapter

        binding.searchEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                getImages(s.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

        getImages("")


        return binding.root
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    private fun getImages(searchInput: String) {
        viewModel.getImages(searchInput).observe(viewLifecycleOwner, Observer { images ->
            binding.status = Result.Status.LOADING
            Handler(Looper.getMainLooper()).postDelayed({
                when (images.status) {
                    Result.Status.SUCCESS -> setImageUrl(images.data?.data)
                    Result.Status.ERROR -> setErrorMessage(images.message!!)
                }
            }, 1000)
        })
    }

    private fun setErrorMessage(message: String) {
        binding.infoTv.text = message
        binding.status = Result.Status.ERROR
    }

    private fun setImageUrl(data: GenericListResponse<RedditImage>?) {
        val reditImages: List<RedditImage>? = data?.children?.map {
            RedditImage(
                0,
                it.data!!.id,
                it.data.title,
                it.data.author,
                it.data.created,
                it.data.thumbnail ?: "",
                it.data.preview?.images?.get(0)?.source?.url ?: "",
                it.data.preview?.images?.get(0)?.source?.width ?: 0,
                it.data.preview?.images?.get(0)?.source?.height ?: 0,
                false
            )
        }

        if (reditImages.isNullOrEmpty()) {
            binding.status = Result.Status.ERROR
        } else {
            setImagesAdapter(reditImages)
            binding.status = Result.Status.SUCCESS
        }
    }

    private fun setImagesAdapter(reditImages: List<RedditImage>?) {
        adapter.submitList(reditImages)
    }
}