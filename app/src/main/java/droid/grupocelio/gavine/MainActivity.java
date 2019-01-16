package droid.grupocelio.gavine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import droid.grupocelio.gavine.model.Summoner;
import droid.grupocelio.gavine.utils.AppPreferences;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static String RIOT_API_KEY = "RGAPI-2f8c2ce9-5417-43bd-a87e-f3847b9152bb";

    com.google.android.material.bottomappbar.BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    TextView txtviewTitle;
    androidx.appcompat.widget.SearchView searchView;
    TextView txtviewExample;
    Summoner summoner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //App Parameters
        AppPreferences.region = "euw1";
        AppPreferences.riotApiKey = RIOT_API_KEY;

        //RecyclerView recyclerView = findViewById(R.id.recyclerView);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        floatingActionButton = findViewById(R.id.fab);
        txtviewTitle = findViewById(R.id.txtviewTitle);
        searchView = findViewById(R.id.searchView);
        txtviewExample = findViewById(R.id.prueba);

        // GetData
        try { summoner = Summoner.getSummonerByName("RubenGlam"); }
        catch (Exception e) { e.printStackTrace(); }

        // GoogleSans Font
        txtviewTitle.setTypeface(Typeface.createFromAsset(this.getAssets(), "fonts/GoogleSans-Medium.ttf"));
        // Listeners
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        searchView.setOnQueryTextListener(new ExtendOnQueryTextListener());
        searchView.setOnClickListener(new ExtendOnClickListener(this, summoner));

    }

    private class ExtendOnClickListener implements View.OnClickListener {

        Context context;
        Summoner summoner;

        public ExtendOnClickListener(Context context, Summoner summoner) {

            this.context = context;
            this.summoner = summoner;

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.searchView:
                    MainActivity.this.txtviewExample.setText(String.valueOf(summoner.getSummonerLevel()));
                    break;
            }
        }
    }

    private class ExtendOnQueryTextListener implements SearchView.OnQueryTextListener {

        String textQuery;

        public ExtendOnQueryTextListener() {

        }

        @Override
        public boolean onQueryTextSubmit(String query)
        {
            textQuery = query;
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }

}
