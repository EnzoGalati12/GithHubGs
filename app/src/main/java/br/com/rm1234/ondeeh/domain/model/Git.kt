package br.com.rm1234.ondeeh.domain.model

import com.google.gson.annotations.SerializedName


data class Git(
    val name: String,
    @SerializedName("avatar_url") val image: String

)
