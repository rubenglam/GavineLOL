package droid.grupocelio.gavine

import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.TextView
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.WindowDecorActionBar
import androidx.fragment.app.FragmentTransaction
import droid.grupocelio.gavine.fragments.*
import droid.grupocelio.gavine.views.AccountDialog
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.view_action_bar.*
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener,
        EsportsFragment.OnFragmentInteractionListener, RankingFragment.OnFragmentInteractionListener,
        ChampionsFragment.OnFragmentInteractionListener, NewsFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //var mActionBar : ActionBar? = null
    var mViewActionBar : View? = null
    var mEsportsFragment : EsportsFragment? = null
    var mChampionsFragment : ChampionsFragment? = null
    var mHomeFragment : HomeFragment? = null
    var mRankingFragment : RankingFragment? = null
    var mNewsFragment : NewsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //mActionBar = supportActionBar
        //mActionBar!!.setDisplayShowCustomEnabled(true);
        //mActionBar!!.setDisplayShowTitleEnabled(false);

        //var inflator = LayoutInflater.from(this)
        viewActionBar.findViewById<TextView>(R.id.title).typeface = Typeface.createFromAsset(this.assets, "fonts/GoogleSans-Medium.ttf")

        //mActionBar!!.setCustomView(mViewActionBar)
        //var txtViewTitle = mViewActionBar!!.findViewById<TextView>(R.id.title)
        //txtViewTitle.typeface = Typeface.createFromAsset(this.assets, "fonts/GoogleSans-Medium.ttf")
        //txtViewTitle.setTextColor(resources.getColor(R.color.colorAccent))

        //supportActionBar!!.elevation = 0f

        navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        (navigation_view as BottomNavigationView).selectedItemId = R.id.navigation_home

        btnProfile.setOnClickListener {
            val suppTransaction = supportFragmentManager.beginTransaction();
            val fragmentDialog = AccountDialog.newInstance("hola");
            fragmentDialog.show(suppTransaction, "dialog")
        }

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item ->
        val transaction = getSupportFragmentManager().beginTransaction()
        when (item.itemId) {
            R.id.navigation_esports -> {
                //mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_esports)
                createFragmentEsports(transaction)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_champion -> {
                //mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_champion)
                createFragmentChampions(transaction)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                //mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_home)
                createFragmentHome(transaction)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ranking -> {
                //mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_ranking)
                createFragmentRanking(transaction)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                //mViewActionBar?.findViewById<TextView>(R.id.title)!!.text = getString(R.string.title_news)
                createFragmentNews(transaction)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    //region INITIALIZE FRAGMENTS

    fun createFragmentEsports(transaction : FragmentTransaction) {
        if(mEsportsFragment == null) {
            mEsportsFragment = EsportsFragment.newInstance()
        }
        transaction.replace(R.id.container, mEsportsFragment as androidx.fragment.app.Fragment)
        transaction.commit()
    }

    fun createFragmentChampions(transaction : FragmentTransaction) {
        if(mChampionsFragment == null) {
            mChampionsFragment = ChampionsFragment.newInstance()
        }
        transaction.replace(R.id.container, mChampionsFragment as androidx.fragment.app.Fragment)
        transaction.commit()
    }

    fun createFragmentHome(transaction : FragmentTransaction) {

        if(mHomeFragment == null) {
            mHomeFragment = HomeFragment.newInstance()
            mHomeFragment!!.setOnScrollListener(ExtendOnScrollChangedListener(appBarLayout))
        }
        transaction.replace(R.id.container, mHomeFragment as androidx.fragment.app.Fragment)
        transaction.commit()
    }

    fun createFragmentRanking(transaction : FragmentTransaction) {
        if(mRankingFragment == null) {
            mRankingFragment = RankingFragment.newInstance()
        }
        transaction.replace(R.id.container, mRankingFragment as androidx.fragment.app.Fragment)
        transaction.commit()
    }

    fun createFragmentNews(transaction : FragmentTransaction) {
        if(mNewsFragment == null) {
            mNewsFragment = NewsFragment.newInstance()
        }
        transaction.replace(R.id.container, mNewsFragment as androidx.fragment.app.Fragment)
        transaction.commit()
    }

    //endregion

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //region OnScrollChanged

    class ExtendOnScrollChangedListener : View.OnScrollChangeListener {

        var mActionBar : View? = null

        constructor(view : View) {
            mActionBar = view
        }

        override fun onScrollChange(v: View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
            if(scrollY > 0) mActionBar!!.elevation = 8f
            else mActionBar!!.elevation = 0f
        }

    }

    //endregion

}
