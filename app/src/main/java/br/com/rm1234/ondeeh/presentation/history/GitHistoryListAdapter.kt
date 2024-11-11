package br.com.rm1234.ondeeh.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rm1234.ondeeh.databinding.CepHistoryItemBinding
import br.com.rm1234.ondeeh.domain.model.Git
import com.bumptech.glide.Glide

class GitHistoryListAdapter(
    private val onDeleteClick: (Git) -> Unit
) : RecyclerView.Adapter<GitHistoryListAdapter.GitViewHolder>() {

    private var gits: List<Git> = emptyList()

    class GitViewHolder(val binding: CepHistoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        val binding = CepHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
        val currentGit = gits[position]
        holder.binding.tvLinha1.text = currentGit.name

        // Carregue a imagem usando o Glide
        Glide.with(holder.itemView.context)
            .load(currentGit.image) // Substitua por seu atributo de URL de imagem
            .into(holder.binding.gitImage) // Substitua pelo ID correto do ImageView

        holder.binding.icDelete.setOnClickListener { onDeleteClick(currentGit) }
    }

    override fun getItemCount() = gits.size

    fun setGits(gits: List<Git>) {
        this.gits = gits
        notifyDataSetChanged()
    }
}
