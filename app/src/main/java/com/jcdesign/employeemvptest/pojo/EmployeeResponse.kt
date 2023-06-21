package com.jcdesign.employeemvptest.pojo


import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @SerializedName("response")
    val response: List<Employee>
)