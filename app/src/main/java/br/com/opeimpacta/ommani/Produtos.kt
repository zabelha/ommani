package br.com.opeimpacta.ommani

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "produtos")
class Produtos: Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    var nome = ""
    var ementa = ""
    var foto = ""
    var tipo = ""

    override fun toString(): String {
        return "$nome, $tipo"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }

}