package br.com.opeimpacta.ommani

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ProdutoActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        val produto = intent?.getSerializableExtra("produto")

        Toast.makeText(this, "clicou no: $produto", Toast.LENGTH_LONG).show()

    }

}