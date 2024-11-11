package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.repository.GitRepository

class DeleteItemHistoryUseCase(private val repository: GitRepository) {
    suspend operator fun invoke(git: String) {
        return repository.deleteItemHistory(git)
    }
}
