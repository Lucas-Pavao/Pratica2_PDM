package pdm.pratica02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MSG = "msg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            finish(); // Fecha a atividade se estiver na horizontal
            return;
        }
        setContentView(R.layout.activity_detail);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String msg = extras.getString(EXTRA_MSG);
            DetailFragment detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            detailFragment.setText(msg);
        }
    }
}