package br.com.opeimpacta.ommani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity() {

    private val TAG = "LMSApp"
    private val className: String
        get(){
            val s =  javaClass.name // br.com.izabellaimpacta.firstapp.DebugActivity
            return s.substring(s.lastIndexOf("."))
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className onCreate() executando")
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className onStart() executando")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$className onRestart() executando")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$className onResume() executando")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$className onPause() executando")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$className onStop() executando")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$className onDestroy() executando")
    }
}