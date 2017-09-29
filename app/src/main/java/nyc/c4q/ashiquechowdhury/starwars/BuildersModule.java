package nyc.c4q.ashiquechowdhury.starwars;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nyc.c4q.ashiquechowdhury.starwars.starwars.StarWarsActivity;
import nyc.c4q.ashiquechowdhury.starwars.starwars.StarWarsActivityModule;

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {StarWarsActivityModule.class})
    abstract StarWarsActivity bindsSWActivity();
}