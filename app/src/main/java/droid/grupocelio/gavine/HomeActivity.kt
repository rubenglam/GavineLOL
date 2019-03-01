package droid.grupocelio.gavine

import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.TextView
import android.content.Context
import android.view.View
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.WindowDecorActionBar
import droid.grupocelio.gavine.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener  {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var mActionBar : ActionBar? = null
    var mViewActionBar : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mActionBar = supportActionBar
        mActionBar!!.setDisplayShowCustomEnabled(true);
        mActionBar!!.setDisplayShowTitleEnabled(false);

        var inflator = LayoutInflater.from(this)
        mViewActionBar = inflator.inflate(R.layout.view_action_bar, null)

        mActionBar!!.setCustomView(mViewActionBar)
        mViewActionBar!!.findViewById<TextView>(R.id.title).typeface = Typeface.createFromAsset(this.assets, "fonts/GoogleSans-Medium.ttf")
        //toolbar_top.inflateMenu(R.menu.home_menu)

        navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        (navigation_view as BottomNavigationView).selectedItemId = R.id.navigation_home

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item ->

        when (item.itemId) {
            R.id.navigation_esports -> {
                mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_esports)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_champion -> {
                mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_champion)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_home)
                createFragmentHome("Home")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ranking -> {
                mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_ranking)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_news)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun createFragmentHome(text: String) {
        val transaction = getSupportFragmentManager().beginTransaction()
        var fragment = HomeFragment.newInstance(text, "n") as androidx.fragment.app.Fragment
        transaction.replace(R.id.container, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
