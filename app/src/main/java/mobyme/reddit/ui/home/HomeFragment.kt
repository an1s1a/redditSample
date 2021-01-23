package mobyme.reddit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import mobyme.reddit.R
import mobyme.reddit.databinding.FragmentHomeBinding
import mobyme.reddit.ui.BaseFragment
import mobyme.reddit.ui.adapter.RedditImageAdapter
import mobyme.reddit.ui.adapter.RedditImageClickListener

class HomeFragment: BaseFragment<HomeViewModel>() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = RedditImageAdapter(RedditImageClickListener {  })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val manager = GridLayoutManager(activity, 3)
        binding.imageGrid.layoutManager = manager

        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int) =  when (position) {
                0 -> 3
                else -> 1
            }
        }

        binding.imageGrid.adapter = adapter

        return binding.root
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }
}