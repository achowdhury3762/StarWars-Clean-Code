package nyc.c4q.ashiquechowdhury.starwars;

import android.app.Application;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nyc.c4q.ashiquechowdhury.starwars.api.StarWarsService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class AppModule {
    private static final String baseUrl = "http://swapi.co/api/";

    @Provides
    Context bindsContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Singleton
    @Provides
    StarWarsService providesSWService(Retrofit retrofit) {
        return retrofit.create(StarWarsService.class);
    }
}