package nyc.c4q.ashiquechowdhury.starwars.network;

import dagger.Module;
import dagger.Provides;
import nyc.c4q.ashiquechowdhury.starwars.starwars.StarWarsView;

@Module
public class StarWarsPresenterModule {
    private final StarWarsView view;

    public StarWarsPresenterModule(StarWarsView view) {
        this.view = view;
    }

    @Provides
    StarWarsView provideSWView() {
        return view;
    }
}
