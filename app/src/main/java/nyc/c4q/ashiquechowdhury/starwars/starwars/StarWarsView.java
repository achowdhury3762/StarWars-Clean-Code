package nyc.c4q.ashiquechowdhury.starwars.starwars;


import nyc.c4q.ashiquechowdhury.starwars.network.StarWarsCharacter;

public interface StarWarsView {
    void load();

    void showCharacter(StarWarsCharacter character);

    void showLoadingError(String error);

    void stopload();
}
