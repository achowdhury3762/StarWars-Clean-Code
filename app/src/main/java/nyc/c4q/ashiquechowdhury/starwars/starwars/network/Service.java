package nyc.c4q.ashiquechowdhury.starwars.starwars.network;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class Service {
    private StarWarsService service;

    public Service(StarWarsService service) {
        this.service = service;
    }

    public Disposable getCharacter(int characterId, final CharacterCallback callback) {
        return service.getCharacter(characterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<StarWarsCharacter>() {
                    @Override
                    public void onNext(@NonNull StarWarsCharacter starWarsCharacter) {
                        callback.onSuccess(starWarsCharacter);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface CharacterCallback {
        void onSuccess(StarWarsCharacter character);

        void onError();
    }
}
