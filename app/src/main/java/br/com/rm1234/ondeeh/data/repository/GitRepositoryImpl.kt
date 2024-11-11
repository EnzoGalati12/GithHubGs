package br.com.rm1234.ondeeh.data.repository

import br.com.rm1234.ondeeh.data.local.dao.GitDao
import br.com.rm1234.ondeeh.data.remote.api.GitService
import br.com.rm1234.ondeeh.domain.model.Git
import br.com.rm1234.ondeeh.domain.repository.GitRepository

class GitRepositoryImpl(
    private val cepDao: GitDao,
    private val gitService: GitService
) : GitRepository {

    override suspend fun getGit(git: String): Git {
        val cachedGit = cepDao.getGit(git)
        return if (cachedGit != null) {
            cachedGit.toGit()
        } else {
            val response = gitService.getGit(git)
            cepDao.insertCep(response.toCepEntity())
            response.toCep()
        }
    }

    override suspend fun getHistoryGits(): List<Git> {
        return cepDao.getHistoryCeps().map { it.toGit() }
    }

    override suspend fun deleteItemHistory(git: String) {
        val cachedGit = cepDao.getGit(git)
        cachedGit?.let { cepDao.delete(cachedGit) }
    }

    override suspend fun deleteAllHistory(){
        cepDao.deleteAll()

    }

}
