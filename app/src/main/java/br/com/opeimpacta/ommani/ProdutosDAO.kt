package br.com.opeimpacta.ommani

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutosDAO {

    @Query("SELECT * FROM produtos where id = :id")
    fun getById(id:Long): Produtos?

    @Query("SELECT * FROM produtos")
    fun getAll(): List<Produtos>

    @Insert
    fun insert(produtos: Produtos)

    @Delete
    fun delete(produtos: Produtos)
}