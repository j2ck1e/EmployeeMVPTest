package com.jcdesign.employeemvptest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcdesign.employeemvptest.R
import com.jcdesign.employeemvptest.pojo.Employee

class EmployeeAdapter(private var employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    fun setEmployees(newEmployees: List<Employee>) {
        employees = newEmployees
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.textViewName.text = employee.name
        holder.textViewLastName.text = employee.lName
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textView_name)
        val textViewLastName: TextView = itemView.findViewById(R.id.textView_lastname)
    }

}