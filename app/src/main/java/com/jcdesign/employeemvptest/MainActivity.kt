package com.jcdesign.employeemvptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcdesign.employeemvptest.adapters.EmployeeAdapter
import com.jcdesign.employeemvptest.api.ApiFactory
import com.jcdesign.employeemvptest.pojo.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewEmployees: RecyclerView
    private lateinit var adapter: EmployeeAdapter
    private lateinit var disposable: Disposable
    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewEmployees = findViewById(R.id.recycler_view_employees)
        recyclerViewEmployees.layoutManager = LinearLayoutManager(this)
        val employeeList: List<Employee> = mutableListOf()
        adapter = EmployeeAdapter(employeeList)
        recyclerViewEmployees.adapter = adapter
        val apiService = ApiFactory.getApiService()
        compositeDisposable = CompositeDisposable()
        disposable = apiService.getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ employeeResponse -> adapter.setEmployees(employeeResponse.response) },
                { error ->
                    Toast.makeText(this, "Ошибка получения данных", Toast.LENGTH_LONG).show()
                })
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}