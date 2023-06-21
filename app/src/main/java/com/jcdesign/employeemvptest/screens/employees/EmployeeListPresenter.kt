package com.jcdesign.employeemvptest.screens.employees

import android.widget.Toast
import com.jcdesign.employeemvptest.api.ApiFactory
import com.jcdesign.employeemvptest.pojo.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class EmployeeListPresenter(private var view: EmployeeListView) {
    private lateinit var disposable: Disposable
    private lateinit var compositeDisposable: CompositeDisposable

    fun loadData() {
        val apiService = ApiFactory.getApiService()
        compositeDisposable = CompositeDisposable()
        disposable = apiService.getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ employeeResponse -> view.showData(employeeResponse.response)},
                { error -> view.showError()})
        compositeDisposable.add(disposable)
    }

    fun disposeDisposable() {
        compositeDisposable.dispose()
    }
}