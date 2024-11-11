package br.com.rm1234.ondeeh.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rm1234.ondeeh.databinding.ActivityMainBinding
import br.com.rm1234.ondeeh.presentation.detail.DetalheActivity
import br.com.rm1234.ondeeh.presentation.history.GitHistoryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btPesquisar.setOnClickListener {
            val name = binding.etCep.text.toString()
            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("NAME", name)
            startActivity(intent)
        }

        binding.btHistorico.setOnClickListener {
            val intent = Intent(this, GitHistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
