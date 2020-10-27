package br.com.opeimpacta.ommani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_cadastro.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.botao_cadastrar
import kotlinx.android.synthetic.main.login.campo_senha
import kotlinx.android.synthetic.main.login.progressbar

class TelaCadastroActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)


        supportActionBar?.title = "Cadastro"

        botao_cadastrar.setOnClickListener { onClickCadastro()
            var p = Produtos()

        }

    }

    fun onClickCadastro(){

        progressbar.visibility = View.VISIBLE
        Handler().postDelayed(
            {
                progressbar.visibility = View.GONE
                val valorSenha = campo_senha.text.toString()
                val valorConfSenha = campo_senhaconfirmar.text.toString()

                if(valorSenha == valorConfSenha ){
                    var intent = Intent(this, TelaInicialActivity::class.java)

                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Senhas Diferentes", Toast.LENGTH_LONG).show()
                }

            }, 1000
        )

    }
}

