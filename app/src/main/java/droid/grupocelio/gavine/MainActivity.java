package droid.grupocelio.gavine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import droid.grupocelio.gavine.utils.AppPreferences;
import droid.grupocelio.gavine.utils.ConnectionApi;
import droid.grupocelio.gavine.utils.jsonReader;

import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static String RIOT_API_KEY = "RGAPI-2f8c2ce9-5417-43bd-a87e-f3847b9152bb";

    com.google.android.material.bottomappbar.BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    TextView txtviewTitle;
    androidx.appcompat.widget.SearchView searchView;
    TextView txtviewExample;

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
        searchView.setOnClickListener(new ExtendOnClickListener(this));

        //GetDataOnStart();

    }

    private String GetDataOnStart() {

        ConnectionApi connection = new ConnectionApi();
        connection.start();
        return  connection.getNameS();
    }

    private class ExtendOnClickListener implements View.OnClickListener {

        Context context;

        public ExtendOnClickListener(Context context) {

            this.context = context;

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.searchView:
                    searchView.setAnimation(new TranslateAnimation(0,0,0,100,100,100,0,10));
                    MainActivity.this.txtviewExample.setText(GetDataOnStart());
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
