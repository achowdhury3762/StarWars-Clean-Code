package nyc.c4q.ashiquechowdhury.starwars.starwars;


import javax.inject.Inject;

import nyc.c4q.ashiquechowdhury.starwars.network.Service;
import nyc.c4q.ashiquechowdhury.starwars.network.StarWarsCharacter;

public class StarWarsPresenter {
    private final StarWarsView view;
    private Service service;

    @Inject
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
