package br.com.rm1234.ondeeh.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rm1234.ondeeh.domain.model.Git
import br.com.rm1234.ondeeh.domain.usecase.DeleteAllHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.DeleteItemHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.GetHistoryGitUseCase
import kotlinx.coroutines.launch

class GitHistoryViewModel(
    private val getHistoryGitUseCase: GetHistoryGitUseCase,
    private val deleteItemHistoryUseCase: DeleteItemHistoryUseCase,
    private val deleteAllHistoryUseCase: DeleteAllHistoryUseCase
) : ViewModel() {

    private val _gitAllHistory = MutableLiveData<List<Git>>()
    val gitAllHistory: LiveData<List<Git>> get() = _gitAllHistory

    fun getHistory() {
        viewModelScope.launch {
            val result = getHistoryGitUseCase()
            _gitAllHistory.value = result
        }
    }

    fun delete(cep: String) {
        viewModelScope.launch {
            deleteItemHistoryUseCase(cep)
            getHistory()
        }
    }


    fun deleteAll() {
        viewModelScope.launch {
            deleteAllHistoryUseCase()

        }
    }

}
