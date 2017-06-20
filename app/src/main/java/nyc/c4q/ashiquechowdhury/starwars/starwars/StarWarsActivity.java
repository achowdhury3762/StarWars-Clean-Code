package nyc.c4q.ashiquechowdhury.starwars.starwars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import nyc.c4q.ashiquechowdhury.starwars.BaseApp;
import nyc.c4q.ashiquechowdhury.starwars.R;
import nyc.c4q.ashiquechowdhury.starwars.network.Service;
import nyc.c4q.ashiquechowdhury.starwars.network.StarWarsCharacter;
import nyc.c4q.ashiquechowdhury.starwars.network.StarWarsPresenterModule;

public class StarWarsActivity extends AppCompatActivity implements StarWarsView {
    private ProgressBar progressBar;
    private EditText characterIdInput;
    private TextView characterNameTextV;

    @Inject Service service;
    @Inject StarWarsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);

        ((BaseApp) getApplication()).getDepsBuilder()
                .starWarsPresenterModule(new StarWarsPresenterModule(this))
                .build().inject(this);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.INVISIBLE);
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