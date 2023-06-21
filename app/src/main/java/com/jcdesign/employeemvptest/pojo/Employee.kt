package com.jcdesign.employeemvptest.pojo


import com.google.gson.annotations.SerializedName

data class Employee(
//    @SerializedName("avatr_url")
//    val avatrUrl: String,
//    @SerializedName("birthday")
//    val birthday: String,
    @SerializedName("f_name")
    val name: String,
    @SerializedName("l_name")
    val lName: String,
//    @SerializedName("specialty")
//    val specialty: List<Specialty>
)