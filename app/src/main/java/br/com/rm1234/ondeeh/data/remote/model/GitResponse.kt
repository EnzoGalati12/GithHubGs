package br.com.rm1234.ondeeh.data.remote.model

import androidx.room.PrimaryKey
import br.com.rm1234.ondeeh.data.local.entity.GitEntity
import br.com.rm1234.ondeeh.domain.model.Git
import com.google.gson.annotations.SerializedName

data class GitResponse(
    @PrimaryKey val name: String,
    @SerializedName("avatar_url") val image: String
) {
    fun toCep(): Git {
        return Git(
            name = name,
            image = image
        )

    }

    fun toCepEntity(): GitEntity {
        return GitEntity(
            name = name,
            image = image
        )
    }
}
