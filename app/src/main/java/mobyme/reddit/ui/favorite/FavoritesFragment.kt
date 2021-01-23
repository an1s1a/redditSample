package mobyme.reddit.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import mobyme.reddit.R
import mobyme.reddit.databinding.FragmentFavoritesBinding
import mobyme.reddit.ui.BaseFragment

class FavoritesFragment: BaseFragment<FavoritesViewModel> (){

    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)
        return binding.root
    }

    override fun getViewModel(): Class<FavoritesViewModel> {
        return FavoritesViewModel::class.java
    }
}