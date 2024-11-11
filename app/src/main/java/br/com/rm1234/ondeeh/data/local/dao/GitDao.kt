package br.com.rm1234.ondeeh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.rm1234.ondeeh.data.local.entity.GitEntity


@Dao
interface GitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCep(cep: GitEntity)

    @Query("SELECT * FROM git_table WHERE name = :name LIMIT 1")
    suspend fun getGit(name: String): GitEntity?

    @Query("SELECT * FROM git_table ")
    suspend fun getHistoryCeps(): List<GitEntity>

    @Delete
    suspend fun delete(cep: GitEntity)

    @Query("DELETE FROM git_table")
    suspend fun deleteAll()
}
