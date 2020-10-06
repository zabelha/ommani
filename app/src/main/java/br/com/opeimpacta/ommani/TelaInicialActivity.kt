package br.com.opeimpacta.ommani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*
import br.com.opeimpacta.ommani.Produtos as Produtos

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        this.drawerLayout = layoutMenu_lateral
        this.navView = menu_lateral

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Nossos Produtos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerProdutos?.layoutManager = LinearLayoutManager(this)
        recyclerProdutos?.itemAnimator = DefaultItemAnimator()
        recyclerProdutos.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskProdutos()
    }


    private  var produtos = listOf<Produtos>()
    fun taskProdutos() {
        produtos = ProdutoService.getProdutos(this)
        recyclerProdutos?.adapter = ProdutoAdapter(produtos) { onClickProduto(it)}
    }

    fun onClickProduto(produtos: Produtos) {
        val it = Intent(this, ProdutoActivity::class.java)
        it.putExtra("produto", produtos)
        startActivity(it)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.action_buscar){
            Toast.makeText(this, "botão buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "CARREGANDO...", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}