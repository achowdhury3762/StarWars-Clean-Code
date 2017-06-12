package nyc.c4q.ashiquechowdhury.starwars.starwars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import nyc.c4q.ashiquechowdhury.starwars.R;
import nyc.c4q.ashiquechowdhury.starwars.network.Service;
import nyc.c4q.ashiquechowdhury.starwars.network.StarWarsCharacter;
import nyc.c4q.ashiquechowdhury.starwars.network.StarWarsService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsActivity extends AppCompatActivity implements StarWarsView {
    private ProgressBar progressBar;
    private EditText characterIdInput;
    private TextView characterNameTextV;
    private StarWarsPresenter presenter;
    private String BASE_URL = "http://swapi.co/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.INVISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StarWarsService swService = retrofit.create(StarWarsService.class);
        Service service = new Service(swService);
        presenter = new StarWarsPresenter(service, this);
    }

    @Override
    public void load() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCharacter(StarWarsCharacter character) {
        characterNameTextV = (TextView) findViewById(R.id.character_name_tview);

        progressBar.setVisibility(View.INVISIBLE);
        characterNameTextV.setText(character.getName());
    }

    @Override
    public void showLoadingError() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void stopload() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void onClickSearch(View view) {
        characterIdInput = (EditText) findViewById(R.id.starwars_id_input);

        presenter.getCharacter(Integer.valueOf(characterIdInput.getText().toString()));
    }
}