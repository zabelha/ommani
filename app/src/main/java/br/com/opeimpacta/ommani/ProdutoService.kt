package br.com.opeimpacta.ommani

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ProdutoService {

    val host = "https://izabella.pythonanywhere.com"
    val TAG = "ws_Ommani"

    fun getProdutos (context: Context): List<Produtos> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/produtos"
            val json = HttpHelper.get(url)
            return parserJson(json)
        } else {
            return ArrayList<Produtos>()
        }
        //Banco
        // val dao = DatabaseManager.getProdutosDAO()
        // return dao.getAll()
    }

    fun getUser (context: Context): List<Produtos> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/produtos"
            val json = HttpHelper.get(url)
            return parserJson(json)
        } else {
            return ArrayList<Produtos>()
        }
        //Banco
        // val dao = DatabaseManager.getProdutosDAO()
        // return dao.getAll()
    }


    fun save(produto: Produtos): Response {
        //API
        val json = HttpHelper.post("$host/produtos", produto.toJson())
        return parserJson(json)
        //Banco
        // val dao = DatabaseManager.getProdutosDAO()
        // dao.insert(produto)
        // return Response("ok", "Cadastrado")
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }



}