package nyc.c4q.ashiquechowdhury.starwars.api;

import io.reactivex.Observable;
import nyc.c4q.ashiquechowdhury.starwars.model.StarWarsCharacter;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StarWarsService {
    @GET("people/{charid}")
    Observable<StarWarsCharacter> getCharacter(@Path("charid") int characterId);
}
