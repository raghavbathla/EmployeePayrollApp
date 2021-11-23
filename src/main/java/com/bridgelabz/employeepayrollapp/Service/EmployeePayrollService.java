package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.demo.dto.EmployeePayrollDTO;
import com.bridgelabz.demo.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

	 @Override
	    public List<EmployeePayrollData> getEmployeePayrollData() {
		 return employeePayrollList;
	    }

	    @Override
	    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
	    	return employeePayrollList.get(employeeId-1);
	    }

	    @Override
	    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
	    	EmployeePayrollData empData = null;
	        empData = new EmployeePayrollData(employeePayrollList.size()+1,empPayrollDTO);
	        employeePayrollList.add(empData);
	        return empData;
	    }

	    @Override
	    public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {
	    	EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
	        empData.setName(empPayrollDTO.name);
	        empData.setSalary(empPayrollDTO.salary);
	        employeePayrollList.set(employeeId-1, empData);
	        return empData;
	    }

	    @Override
	    public void deleteEmployeePayrollData(int employeeId) {
	    	employeePayrollList.remove(employeeId-1);
	    }

}
