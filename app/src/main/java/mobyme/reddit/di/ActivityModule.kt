package mobyme.reddit.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mobyme.reddit.annotations.ActivityScope
import mobyme.reddit.ui.main.MainActivity

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun mainActivity(): MainActivity
}