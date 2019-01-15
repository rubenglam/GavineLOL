package droid.grupocelio.gavine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView recyclerView = findViewById(R.id.recyclerView);
        com.google.android.material.bottomappbar.BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        TextView txtviewTitle = findViewById(R.id.txtviewTitle);

        txtviewTitle.setTypeface(Typeface.createFromAsset(this.getAssets(), "fonts/GoogleSans-Medium.ttf"));

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

        GetData();

    }

    private void GetData() {
        try
        {

            new Thread(new Runnable() {
                public void run() {
                    try {
                        JSONObject jsonObject;
                        jsonObject = jsonReader.readJsonFromUrl("https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/RiotSchmick?api_key=RGAPI-e339225e-a4f4-44b9-8015-b4bc13d516d4");
                        jsonObject.toString();
                    }
                    catch (Exception e) { e.printStackTrace(); }
                }
            }).start();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
