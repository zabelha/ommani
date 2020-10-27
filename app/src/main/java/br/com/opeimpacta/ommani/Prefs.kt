package br.com.opeimpacta.ommani

import android.content.SharedPreferences

object Prefs {

    private fun perfs(): SharedPreferences{
        val context = OmmaniAplication.getInstance().applicationContext
        return context.getSharedPreferences("Ommani", 0)
    }

    fun setString(flag: String, valor: String) = perfs().edit().putString(flag, valor).apply()

    fun getString(flag: String) = perfs().getString(flag, "")

    fun setBoolean(flag: String, valor: Boolean) = perfs().edit().putBoolean(flag, valor).apply()

    fun getBoolean(flag: String) = perfs().getBoolean(flag, false)

}