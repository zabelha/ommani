package br.com.opeimpacta.ommani

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: OmmaniDatabase

    init{
        val context = OmmaniAplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            OmmaniDatabase::class.java,
            "ommani.sqlite"
        ).build()
    }

    fun getProdutosDAO(): ProdutosDAO {
        return dbInstance.produtosDAO()
    }
}