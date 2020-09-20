package br.com.opeimpacta.ommani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TelaCristaisActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cristais)

        supportActionBar?.title = "Cristais"

    }
}