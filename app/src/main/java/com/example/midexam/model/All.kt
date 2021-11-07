package com.example.midexam.model

import com.google.gson.annotations.SerializedName

data class All(
    @SerializedName("confirmed")
    val confirmed: Int?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("recovered")
    val recovered: Int?,
    @SerializedName("updated")
    val updated: String?
)