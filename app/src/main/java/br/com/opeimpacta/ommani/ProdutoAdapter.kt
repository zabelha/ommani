package br.com.opeimpacta.ommani

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.text.FieldPosition

class ProdutoAdapter (
    val produtos: List<Produtos>,
    val onClick: (Produtos) -> Unit): RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

    class ProdutosViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init{
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progressbar)
            cardView = view.findViewById(R.id.card_produto)
        }
    }

    override fun getItemCount() = this.produtos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_produtos, parent, false)

        val holder = ProdutosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val context = holder.itemView.context

        val produto = this.produtos[position]

        holder.cardNome.text = produto.nome
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(produto.foto).fit().into(
            holder.cardImg,
            object : com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            }
        )
            holder.itemView.setOnClickListener {onClick(produto)}
    }
}