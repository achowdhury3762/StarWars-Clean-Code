package nyc.c4q.ashiquechowdhury.starwars.starwars.starwars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import nyc.c4q.ashiquechowdhury.starwars.R;
import nyc.c4q.ashiquechowdhury.starwars.starwars.network.Service;
import nyc.c4q.ashiquechowdhury.starwars.starwars.network.StarWarsCharacter;
import nyc.c4q.ashiquechowdhury.starwars.starwars.network.StarWarsService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsActivity extends AppCompatActivity implements StarWarsView {
    private ProgressBar progressBar;
    private String BASE_URL = "http://swapi.co/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StarWarsService swService = retrofit.create(StarWarsService.class);

        Service service = new Service(swService);
        StarWarsPresenter presenter = new StarWarsPresenter(service, this);
        presenter.getCharacter(1);
    }

    @Override
    public void load() {
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCharacter(StarWarsCharacter character) {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoadingError() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void stopload() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}