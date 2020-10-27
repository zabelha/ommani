package br.com.opeimpacta.ommani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_novo_produto.*

class NovoProduto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_produto)
        setTitle("Novo Produto")

        botao_cadastrar.setOnClickListener {
            val p = Produtos()
            p.nome = fieldNome.text.toString()
            p.ementa = fieldEmenta.text.toString()
            p.foto = fieldFoto.text.toString()
            p.tipo = fieldTipo.text.toString()
            taskAtualizar(p)
        }
    }
    private fun taskAtualizar(produtos: Produtos) {
        Thread {
            ProdutoService.save(produtos)
            runOnUiThread {
                finish()
            }
        }.start()
    }
}