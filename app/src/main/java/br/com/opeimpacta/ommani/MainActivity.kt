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

        Prefs.setString("nome", "Novo nome na string")
        Prefs.setBoolean("tipo", true)

        campo_usuario.setText(Prefs.getString("lembrarNome"))
        campo_senha.setText(Prefs.getString("lembrarSenha"))
        checkLembrar.isChecked = Prefs.getBoolean("lembrar")


        imgLogin.setImageResource(R.drawable.imgloginommani)

        mensagemInicial.setText(R.string.mensagem_inicial)

        botao_login.setOnClickListener {onClickLogin() }

        botao_cadastrar.setOnClickListener { onClickCadastro() }

    }

    fun onClickLogin(){

        progress.visibility = View.VISIBLE

        Handler().postDelayed(
            {
                progress.visibility = View.GONE
                val valorUsuario = campo_usuario.text.toString()
                val valorSenha = campo_senha.text.toString()

                val lembrar = checkLembrar.isChecked
                Prefs.setBoolean("lembrar", lembrar)
                if(lembrar) {
                    Prefs.setString("lembrarNome", valorUsuario)
                    Prefs.setString("lembrarSenha", valorSenha)
                }else {
                    Prefs.setString("lembrarNome", "")
                    Prefs.setString("lembrarSenha", "")
                }


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

    fun onClickCadastro(){

        progressbar.visibility = View.VISIBLE
        Handler().postDelayed(
            {
                progressbar.visibility = View.GONE

                    var intent = Intent(this, TelaCadastroActivity::class.java)

                    startActivity(intent)
            }, 1000
        )

    }

}