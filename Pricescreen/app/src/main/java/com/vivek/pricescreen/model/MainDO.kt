package com.vivek.pricescreen.model

import com.google.gson.annotations.SerializedName

data class MainDO(
    @SerializedName("_id") val _id: String,
    @SerializedName("item_taxes") val item_taxes: List<Int>,
    val name: List<String>,
    val price: Int,
    val specifications: List<Specification> = emptyList(),
)


data class RadioItem(val id: String, val name: String, var isSelected: Boolean = false)

data class CheckboxItem(val id: String, val name: String, var isChecked: Boolean = false)