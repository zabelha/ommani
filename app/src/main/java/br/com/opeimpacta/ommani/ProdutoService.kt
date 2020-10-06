package br.com.opeimpacta.ommani

import android.content.Context

object ProdutoService {

    fun getProdutos(context: Context): List<Produtos> {
        val produtos = mutableListOf<Produtos>()

        for (i in 1..3) {
            val p = Produtos()
            p.nome = "Produto $i"
            p.ementa = "Ementa $i"
            p.tipo = "Tipo $i"
            p.foto = "https://s3.amazonaws.com/img.iluria.com/product/7A7D6F/1304A74/450xN.jpg"
            produtos.add(p)
        }

        return produtos
    }
}