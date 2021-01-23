package mobyme.reddit.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mobyme.reddit.annotations.FragmentScope
import mobyme.reddit.ui.favorite.FavoritesFragment
import mobyme.reddit.ui.home.HomeFragment
import mobyme.reddit.ui.main.ViewPagerFragment

@Module
abstract class FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun viewPagerFragment(): ViewPagerFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun favoritesFragment(): FavoritesFragment
}