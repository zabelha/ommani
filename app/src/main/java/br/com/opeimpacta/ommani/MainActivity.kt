package br.com.opeimpacta.ommani


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.login.*
class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)

        imgLogin.setImageResource(R.drawable.imgloginommani)

        mensagemInicial.setText(R.string.mensagem_inicial)

        botao_login.setOnClickListener {onClickLogin() }

    }

    fun onClickLogin(){

        progress.visibility = View.VISIBLE
        Handler().postDelayed(
            {
                progress.visibility = View.GONE
                val valorUsuario = campo_usuario.text.toString()
                val valorSenha = campo_senha.text.toString()

                if(valorUsuario == "aluno" && valorSenha == "impacta"){
                    var intent = Intent(this, TelaInicialActivity::class.java)


                    intent.putExtra("nome_usuario", valorUsuario)
                    intent.putExtra("numero", 10)

                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Usuário ou Senha incorretos", Toast.LENGTH_LONG).show()
                }

            }, 1000
        )

    }

}