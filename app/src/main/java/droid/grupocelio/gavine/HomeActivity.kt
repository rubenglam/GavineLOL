package droid.grupocelio.gavine

import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import droid.grupocelio.gavine.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener  {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        (navigation_view as BottomNavigationView).selectedItemId = R.id.navigation_home

        txtviewTitle.typeface = Typeface.createFromAsset(this.assets, "fonts/GoogleSans-Medium.ttf")
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item ->

        when (item.itemId) {
            R.id.navigation_esports -> {
                txtviewTitle.setText(R.string.title_esports)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_champion -> {
                txtviewTitle.setText(R.string.title_champion)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                txtviewTitle.setText(R.string.title_home)
                createFragmentHome("Home")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ranking -> {
                txtviewTitle.setText(R.string.title_ranking)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                txtviewTitle.setText(R.string.title_news)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun createFragmentHome(text: String) {
        val transaction = getSupportFragmentManager().beginTransaction()
        var fragment : androidx.fragment.app.Fragment = HomeFragment.newInstance(text, "n") as androidx.fragment.app.Fragment
        transaction.replace(R.id.container, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate()
        return super.onCreateOptionsMenu(menu)
    }

}
