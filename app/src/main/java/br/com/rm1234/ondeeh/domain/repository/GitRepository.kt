package br.com.rm1234.ondeeh.domain.repository

import br.com.rm1234.ondeeh.domain.model.Git

interface GitRepository {
    suspend fun getGit(cep: String): Git

    suspend fun getHistoryGits(): List<Git>

    suspend fun deleteItemHistory(cep: String)

    suspend fun deleteAllHistory()
}
