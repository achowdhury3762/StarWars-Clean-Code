package nyc.c4q.ashiquechowdhury.starwars.starwars;

import dagger.Module;
import dagger.Provides;

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
