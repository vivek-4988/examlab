package com.example.sample.service.data


import com.google.gson.annotations.SerializedName

data class APIModelItem(
    @SerializedName("backupDetails")
    val backupDetails: BackupDetails,
    @SerializedName("coverageURL")
    val coverageURL: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("mediaType")
    val mediaType: Int,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("publishedBy")
    val publishedBy: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("title")
    val title: String
)