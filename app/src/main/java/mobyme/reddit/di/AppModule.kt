package mobyme.reddit.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import mobyme.reddit.Constants
import mobyme.reddit.RedditApplication
import mobyme.reddit.data.RedditDatabase
import mobyme.reddit.data.dao.RedditImageDao
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

    @Provides
    @Singleton
    fun provideRedditDatabase(app: Application): RedditDatabase = Room.databaseBuilder(
        app,
        RedditDatabase::class.java,
        Constants.DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideLocationDao(database: RedditDatabase): RedditImageDao = database.redditImageDao()

}