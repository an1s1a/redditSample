package mobyme.reddit.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mobyme.reddit.annotations.ViewModelKey
import mobyme.reddit.ui.favorite.FavoritesViewModel
import mobyme.reddit.ui.home.HomeViewModel
import mobyme.reddit.ui.imageslider.ImageSliderViewModel
import mobyme.reddit.ui.main.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun provideFavoritesViewModel(favoritesViewModel: FavoritesViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(ImageSliderViewModel::class)
    abstract fun provideImageSliderViewModel(imageSliderViewModel: ImageSliderViewModel): ViewModel
}