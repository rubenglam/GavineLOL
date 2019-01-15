package droid.grupocelio.gavine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import droid.grupocelio.gavine.utils.ConnectionApi;
import droid.grupocelio.gavine.utils.jsonReader;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
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

    com.google.android.material.bottomappbar.BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    TextView txtviewTitle;
    androidx.appcompat.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView recyclerView = findViewById(R.id.recyclerView);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        floatingActionButton = findViewById(R.id.fab);
        txtviewTitle = findViewById(R.id.txtviewTitle);
        searchView = findViewById(R.id.searchView);

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

        GetDataOnStart();

    }

    private void GetDataOnStart() {

        ConnectionApi connection = new ConnectionApi();
        connection.start();
        searchView.setQueryHint(connection.getNameS());

    }

    private class ExtendOnQueryTextListener implements SearchView.OnQueryTextListener {

        public ExtendOnQueryTextListener() {

        }

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }

}
