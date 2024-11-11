package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.model.Git
import br.com.rm1234.ondeeh.domain.repository.GitRepository

class GetHistoryGitUseCase(private val repository: GitRepository) {
    suspend operator fun invoke(): List<Git> {
        return repository.getHistoryGits()
    }
}
