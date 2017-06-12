package nyc.c4q.ashiquechowdhury.starwars.starwars.starwars;

import nyc.c4q.ashiquechowdhury.starwars.starwars.network.StarWarsCharacter;

public interface StarWarsView {
    void load();

    void showCharacter(StarWarsCharacter character);

    void showLoadingError();

    void stopload();
}
