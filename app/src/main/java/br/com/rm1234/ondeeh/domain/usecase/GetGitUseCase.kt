package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.model.Git
import br.com.rm1234.ondeeh.domain.repository.GitRepository

class GetGitUseCase(private val repository: GitRepository) {

    suspend operator fun invoke(git: String): Git {
        return repository.getGit(git)
    }

}
