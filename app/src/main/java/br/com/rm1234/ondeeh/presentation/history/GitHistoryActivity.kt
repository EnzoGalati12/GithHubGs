package br.com.rm1234.ondeeh.presentation.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rm1234.ondeeh.databinding.ActivityCepHistoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCepHistoryBinding

    private val viewModel: GitHistoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCepHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getHistory()

        viewModel.gitAllHistory.observe(this) {
            val adapter = GitHistoryListAdapter(onDeleteClick = {
                viewModel.delete(it.name)
            })
            binding.rvHistory.adapter = adapter
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            adapter.setGits(it)
        }

        binding.btDeleteAll.setOnClickListener {
            viewModel.deleteAll()
            viewModel.getHistory()

        }
    }
}