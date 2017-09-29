package nyc.c4q.ashiquechowdhury.starwars.starwars;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import nyc.c4q.ashiquechowdhury.starwars.R;
import nyc.c4q.ashiquechowdhury.starwars.model.StarWarsCharacter;

public class StarWarsActivity extends Activity implements StarWarsView {
    private ProgressBar progressBar;
    private EditText characterIdInput;
    private TextView characterNameTextV;

    @Inject StarWarsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);

        AndroidInjection.inject(this);

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
    public void showLoadingError(String loadingError) {
        progressBar.setVisibility(View.INVISIBLE);

        Toast.makeText(getApplicationContext(), "Please enter a different number", Toast.LENGTH_LONG).show();
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