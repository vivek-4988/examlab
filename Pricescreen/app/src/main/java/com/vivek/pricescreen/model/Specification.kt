package com.vivek.pricescreen.model

import com.google.gson.annotations.SerializedName

data class Specification(
    @SerializedName("_id") val id: String,
    val isAssociated: Boolean,
    @SerializedName("isParentAssociate") val isParentAssociate: Boolean,
    @SerializedName("is_required") val isRequired: Boolean,
    val list: List<SpecificationItem>,
    @SerializedName("max_range") val maxRange: Int,
    val modifierGroupId: String,
    val modifierGroupName: String,
    val modifierId: String,
    val modifierName: String,
    val name: List<String>,
    val range: Int,
    @SerializedName("sequence_number") val sequenceNumber: Int,
    val type: Int,
    @SerializedName("unique_id") val uniqueId: Int,
    val user_can_add_specification_quantity: Boolean
)