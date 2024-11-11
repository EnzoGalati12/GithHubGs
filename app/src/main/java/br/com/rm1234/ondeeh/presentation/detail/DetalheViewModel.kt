package br.com.rm1234.ondeeh.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rm1234.ondeeh.domain.model.Git
import br.com.rm1234.ondeeh.domain.usecase.GetGitUseCase
import kotlinx.coroutines.launch

class DetalheViewModel(private val getGitUseCase: GetGitUseCase) : ViewModel() {

    private val _gitData = MutableLiveData<Git>()
    val gitData: LiveData<Git> get() = _gitData

    fun fetchCep(git: String) {
        viewModelScope.launch {
            val result = getGitUseCase(git)
            _gitData.value = result
        }
    }
}
