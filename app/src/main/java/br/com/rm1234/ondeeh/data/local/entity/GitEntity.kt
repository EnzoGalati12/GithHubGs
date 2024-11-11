package br.com.rm1234.ondeeh.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.rm1234.ondeeh.domain.model.Git
import com.google.gson.annotations.SerializedName

@Entity(tableName = "git_table")
data class GitEntity(
    @PrimaryKey val name: String,
    @SerializedName("avatar_url") val image: String
) {
    fun toGit(): Git {
        return Git(
            name = name,
            image = image
        )
    }
}