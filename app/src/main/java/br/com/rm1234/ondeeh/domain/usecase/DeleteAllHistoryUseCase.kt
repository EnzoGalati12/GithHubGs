package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.repository.GitRepository

class DeleteAllHistoryUseCase(private val repository: GitRepository) {
    suspend operator fun invoke() {
        return repository.deleteAllHistory()
    }
}