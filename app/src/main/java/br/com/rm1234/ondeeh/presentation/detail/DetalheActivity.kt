package br.com.rm1234.ondeeh.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.rm1234.ondeeh.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalheActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetalheViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val git = intent.getStringExtra("NAME") ?: ""
        viewModel.fetchCep(git)

        viewModel.gitData.observe(this, Observer { git ->
            binding.tvName.text = git.name

            // Carrega a imagem usando o Glide
            Glide.with(this)
                .load(git.image) // Substitua por seu atributo de URL de imagem
                .into(binding.imagemGit) // Substitua por seu ImageView
        })
    }
}