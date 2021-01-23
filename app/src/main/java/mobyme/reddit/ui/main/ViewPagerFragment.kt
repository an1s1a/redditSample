package mobyme.reddit.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import mobyme.reddit.R
import mobyme.reddit.databinding.FragmentViewpagerBinding
import mobyme.reddit.ui.BaseFragment
import mobyme.reddit.ui.favorite.FavoritesFragment
import mobyme.reddit.ui.home.HomeFragment

class ViewPagerFragment: BaseFragment<MainViewModel>() {

    private lateinit var binding: FragmentViewpagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_viewpager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            HomeFragment(),
            FavoritesFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        return binding.root
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }
}