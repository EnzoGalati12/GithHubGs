package br.com.rm1234.ondeeh.data.remote.api

import br.com.rm1234.ondeeh.data.remote.model.GitResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {
    @GET("users/{name}")
    suspend fun getGit(@Path("name") cep: String): GitResponse
}
