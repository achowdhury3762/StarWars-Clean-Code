package nyc.c4q.ashiquechowdhury.starwars.starwars.starwars;

import nyc.c4q.ashiquechowdhury.starwars.starwars.network.Service;
import nyc.c4q.ashiquechowdhury.starwars.starwars.network.StarWarsCharacter;

public class StarWarsPresenter {
    private Service service;
    private StarWarsView view;

    public StarWarsPresenter(Service service, StarWarsView view) {
        this.service = service;
        this.view = view;
    }

    public void getCharacter(int charId) {
        view.load();

        service.getCharacter(charId, new Service.CharacterCallback() {
            @Override
            public void onSuccess(StarWarsCharacter character) {
                view.stopload();

                view.showCharacter(character);
            }

            @Override
            public void onError() {
                view.stopload();

                view.showLoadingError();
            }
        });
    }
}
