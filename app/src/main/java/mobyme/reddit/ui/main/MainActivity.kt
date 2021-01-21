package mobyme.reddit.ui.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import mobyme.reddit.R
import mobyme.reddit.ui.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}