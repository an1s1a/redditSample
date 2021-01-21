package mobyme.reddit

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import mobyme.reddit.di.DaggerAppComponent

class RedditApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }


}