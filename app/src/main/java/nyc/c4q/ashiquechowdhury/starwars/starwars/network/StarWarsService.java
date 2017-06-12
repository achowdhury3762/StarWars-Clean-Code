package nyc.c4q.ashiquechowdhury.starwars.starwars.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StarWarsService {
    @GET("people/{charid}")
    Observable<StarWarsCharacter> getCharacter(@Path("charid") int characterId);
}
