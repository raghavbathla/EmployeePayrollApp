package com.bridgelabz.employeepayrollapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class EmployeePayroll {
    @RestController
    @RequestMapping("/employeepayroll")
    public class EmployeePayrollController {
        @Autowired
        private IEmployeePayrollService employeePayrollService;

        @RequestMapping(value= {"","/","get"})
        public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
            List<EmployeePayrollData> empDataList =null;
            empDataList =employeePayrollService.getEmployeePayrollData();
            ResponseDTO responseDTO = new ResponseDTO("Get Call Success",empDataList);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }

        @GetMapping("/get/{employeeId}")
        public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("employeeId") int employeeId){
            EmployeePayrollData payrollData=null;
            payrollData=employeePayrollService.getEmployeePayrollDataById(employeeId);
            ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", payrollData);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }

        @PostMapping("/create")
        public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
            EmployeePayrollData payrollData=null;
            payrollData=employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
            ResponseDTO responseDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }

        @PutMapping("/update/{employeeId}")
        public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("employeeId") int employeeId,@RequestBody EmployeePayrollDTO employeePayrollDTO){
            EmployeePayrollData payrollData=null;
            payrollData=employeePayrollService.updateEmployeePayrollData(employeeId,employeePayrollDTO);
            ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll Data for: ", payrollData);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }

        @DeleteMapping("/delete/{employeeId}")
        public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("employeeId") int employeeId){
            employeePayrollService.deleteEmployeePayrollData(employeeId);
            ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "employeeId "+employeeId);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }

    }
}
