package mobyme.reddit.di

import android.content.Context
import dagger.Module
import dagger.Provides
import mobyme.reddit.RedditApplication
import javax.inject.Singleton

/**
 * Here we can define all those objects used and shared throughout the app, like sharedpreferences,
 * application context, services classes.
 * If some of those objects are singletons, they should be annotated with `@Singleton`.
 * */

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: RedditApplication): Context {
        return application.applicationContext
    }

}