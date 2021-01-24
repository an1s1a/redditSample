package mobyme.reddit.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import mobyme.reddit.Constants
import mobyme.reddit.RedditApplication
import mobyme.reddit.annotations.CoroutineScopeIO
import mobyme.reddit.data.RedditDatabase
import mobyme.reddit.data.api.RedditService
import mobyme.reddit.data.dao.RedditImageDao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideRedditDatabase(app: RedditApplication): RedditDatabase = Room.databaseBuilder(
        app,
        RedditDatabase::class.java,
        Constants.DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideRedditImageDao(database: RedditDatabase): RedditImageDao = database.redditImageDao()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): RedditService {
        return retrofit.create(RedditService::class.java)
    }

    @CoroutineScopeIO
    @Provides
    fun provideCoroutineScope() = CoroutineScope(Dispatchers.IO)

}