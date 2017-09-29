package nyc.c4q.ashiquechowdhury.starwars.starwars;

import dagger.Module;
import dagger.Provides;
import nyc.c4q.ashiquechowdhury.starwars.network.Service;

@Module
public class StarWarsActivityModule {

    @Provides
    StarWarsView providesStarWarsView(StarWarsActivity swActivity) {
        return swActivity;
    }

    @Provides
    StarWarsPresenter providesSWPresenter(Service service, StarWarsView view) {
        return new StarWarsPresenter(service, view);
    }
}
