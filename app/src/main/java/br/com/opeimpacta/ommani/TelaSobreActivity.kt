package br.com.opeimpacta.ommani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.activity_tela_sobre.*
import kotlinx.android.synthetic.main.activity_tela_sobre.layoutMenu_lateral
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaSobreActivity : DebugActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_sobre)

        setSupportActionBar(toolbar)

        this.drawerLayout = layoutMenu_lateral
        this.navView = menu_lateral

        supportActionBar?.title = "Sobre Nós"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        botao_mapa.setOnClickListener { onClickMapa() }
        configuraMenuLateral()
    }

    fun onClickMapa(){
            var intent = Intent(this, MapasActivity::class.java)

            startActivity(intent)
        }
    

}