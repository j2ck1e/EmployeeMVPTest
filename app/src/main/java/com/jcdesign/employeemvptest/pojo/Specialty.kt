package com.jcdesign.employeemvptest.pojo


import com.google.gson.annotations.SerializedName

data class Specialty(
    @SerializedName("name")
    val name: String,
    @SerializedName("specialty_id")
    val specialtyId: Int
)