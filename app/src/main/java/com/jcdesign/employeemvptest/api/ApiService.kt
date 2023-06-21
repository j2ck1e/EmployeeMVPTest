package com.jcdesign.employeemvptest.api

import com.jcdesign.employeemvptest.pojo.EmployeeResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("testTask.json")
    fun getEmployees() : Observable<EmployeeResponse>
}