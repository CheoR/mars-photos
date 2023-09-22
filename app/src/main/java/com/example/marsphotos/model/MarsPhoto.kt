package com.example.marsphotos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    // Note: each variable corresponds to key name in response JSON object.
    val id: String,
    // where img_src comes from response but want to use imgSrc
    @SerialName(value = "img_src")
    val imgSrc: String

)

