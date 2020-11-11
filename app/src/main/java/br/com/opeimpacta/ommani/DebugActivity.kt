package br.com.opeimpacta.ommani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.toolbar.*


open class DebugActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = "LMSApp"
    private val className: String
        get(){
            val s =  javaClass.name // br.com.izabellaimpacta.firstapp.DebugActivity
            return s.substring(s.lastIndexOf("."))
        }

    var drawerLayout: DrawerLayout? = null
    var navView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className onCreate() executando")
    }
    protected fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout?.addDrawerListener(toogle)
        toogle.syncState()

        navView?.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_produtos -> {
                var intent = Intent(this, TelaInicialActivity::class.java)

                startActivity(intent)
            }
            R.id.nav_sobre_nos -> {
                var intent = Intent(this, MapasActivity::class.java)

                startActivity(intent)
            }
            R.id.nav_perfil -> {
                var intent = Intent(this, TelaPerfilActivity::class.java)

                startActivity(intent)
            }
            R.id.nav_faq -> {
                var intent = Intent(this, TelaFaqActivity::class.java)

                startActivity(intent)
            }
            R.id.nav_configuracoes -> {
                var intent = Intent(this, TelaConfiguracoesActivity::class.java)

                startActivity(intent)
            }
            R.id.nav_sair -> {
                var intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
            }
        }

        drawerLayout?.closeDrawer(GravityCompat.START)

        return true
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className onStart() executando")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$className onRestart() executando")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$className onResume() executando")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$className onPause() executando")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$className onStop() executando")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$className onDestroy() executando")
    }
}