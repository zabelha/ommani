package br.com.opeimpacta.ommani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TelaYogaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_yoga)

        supportActionBar?.title = "Yoga"
    }
}