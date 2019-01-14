package droid.grupocelio.gavine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import droid.grupocelio.gavine.utils.ConnectionApi;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONObject;

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

        try {
            JSONObject json = ConnectionApi.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
