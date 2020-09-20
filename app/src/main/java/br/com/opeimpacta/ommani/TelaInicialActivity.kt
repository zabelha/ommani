package br.com.opeimpacta.ommani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        imgCristal.setImageResource(R.drawable.cristal)
        imgYoga.setImageResource(R.drawable.yoga)
        imgMassagem.setImageResource(R.drawable.massagem)


        val args = intent.extras
        val nome = args?.getString("nome_usuario")
        val numero = args?.getInt("numero")

        Toast.makeText(this, "Usuário: $nome", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Nossos Produtos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        botao_cristais.setOnClickListener { onClickCristais() }
        botao_yoga.setOnClickListener { onClickYoga() }
        botao_massagem.setOnClickListener { onClickMassagem() }
    }

    fun onClickCristais(){
        var intent = Intent(this, TelaCristaisActivity::class.java)

        startActivity(intent)
    }

    fun onClickYoga(){
        var intent = Intent(this, TelaYogaActivity::class.java)

        startActivity(intent)
    }

    fun onClickMassagem(){
        var intent = Intent(this, TelaMassagemActivity::class.java)

        startActivity(intent)
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
            Toast.makeText(this, "botão atualizar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config){
            Toast.makeText(this, "botão configurar", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}