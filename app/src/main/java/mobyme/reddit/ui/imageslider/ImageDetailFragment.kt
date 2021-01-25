package mobyme.reddit.ui.imageslider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.htmlEncode
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import mobyme.reddit.R
import mobyme.reddit.databinding.FragmentImageDetailBinding
import mobyme.reddit.ui.BaseFragment

class ImageDetailFragment : BaseFragment<ImageSliderViewModel>() {

    val args: ImageDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentImageDetailBinding

    override fun getViewModel(): Class<ImageSliderViewModel> {
        return ImageSliderViewModel::class.java
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image_detail, container, false)

        binding.imageTitle.text = args.imageTitle

        Glide.with(requireContext())
            .load(args.imageUrl.htmlEncode())
            .into(binding.imageDetail)

        return binding.root
    }
}