package nyc.c4q.ashiquechowdhury.starwars.deps;

import javax.inject.Singleton;

import dagger.Component;
import nyc.c4q.ashiquechowdhury.starwars.network.NetModule;
import nyc.c4q.ashiquechowdhury.starwars.network.StarWarsPresenterModule;
import nyc.c4q.ashiquechowdhury.starwars.starwars.StarWarsActivity;

@Singleton
@Component(modules = {NetModule.class, StarWarsPresenterModule.class})
public interface DepsComponent {
    void inject(StarWarsActivity swActivity);
}