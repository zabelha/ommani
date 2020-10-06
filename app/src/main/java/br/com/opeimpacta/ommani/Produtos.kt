package br.com.opeimpacta.ommani

import java.io.Serializable

class Produtos: Serializable {

    var id: Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var tipo = ""

    override fun toString(): String {
        return "$nome, $tipo"
    }
}