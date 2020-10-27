package br.com.opeimpacta.ommani

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Produtos::class), version = 1)
abstract class OmmaniDatabase: RoomDatabase(){
    abstract fun produtosDAO(): ProdutosDAO


}