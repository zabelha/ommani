package br.com.opeimpacta.ommani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.view.MenuItem
import android.widget.ImageView
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

        imgInsta.setImageResource(R.drawable.instagram)
        imgFace.setImageResource(R.drawable.facebook)
        imgSite.setImageResource(R.drawable.web)

        imgInsta.setOnClickListener({ val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ommanicristais/?hl=pt-br"))
            startActivity(i)
        })

        imgFace.setOnClickListener({ val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/izabella.queiroz.79/"))
            startActivity(i)
        })

        imgSite.setOnClickListener({ val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ommanicristais.com.br/index.html"))
            startActivity(i)
        })

        botao_mapa.setOnClickListener { onClickMapa() }
        configuraMenuLateral()
    }

    fun onClickMapa(){
            var intent = Intent(this, MapasActivity::class.java)

            startActivity(intent)
        }
    

}