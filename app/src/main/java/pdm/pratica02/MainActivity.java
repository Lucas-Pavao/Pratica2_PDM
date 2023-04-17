package pdm.pratica02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements OverviewFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onInteraction(String msg) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);
        if (fragment != null && fragment.isVisible()) { // Usar fragmento visivel
            fragment.setText(msg);
        } else { // Chamar nova atividade com fragmento
            Intent intent =
                    new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_MSG, msg);
            startActivity(intent);
        }
    }
}