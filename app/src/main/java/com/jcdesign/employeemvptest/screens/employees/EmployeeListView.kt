package com.jcdesign.employeemvptest.screens.employees

import com.jcdesign.employeemvptest.pojo.Employee

interface EmployeeListView {
    fun showData(employees: List<Employee>)
    fun showError()

}