package com.jcdesign.employeemvptest.screens.employees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcdesign.employeemvptest.R
import com.jcdesign.employeemvptest.adapters.EmployeeAdapter
import com.jcdesign.employeemvptest.api.ApiFactory
import com.jcdesign.employeemvptest.pojo.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class EmployeeListActivity : AppCompatActivity(), EmployeeListView {

    private lateinit var recyclerViewEmployees: RecyclerView
    private lateinit var adapter: EmployeeAdapter
    private lateinit var presenter: EmployeeListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = EmployeeListPresenter(this)
        recyclerViewEmployees = findViewById(R.id.recycler_view_employees)
        recyclerViewEmployees.layoutManager = LinearLayoutManager(this)
        val employeeList: List<Employee> = mutableListOf()
        adapter = EmployeeAdapter(employeeList)
        recyclerViewEmployees.adapter = adapter
        presenter.loadData()
    }
    override fun showData(employees: List<Employee>){
        adapter.setEmployees(employees)
    }
    override fun showError(){
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }
    override fun onDestroy() {
        presenter.disposeDisposable()
        super.onDestroy()
    }

}