package com.Bax.JoinImp.Controller;

import com.Bax.JoinImp.Entity.Address;
import com.Bax.JoinImp.Entity.Employee;
import com.Bax.JoinImp.Repository.AddressRepository;
import com.Bax.JoinImp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class EmployeeContl {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody List<Employee> empData){
        employeeRepository.saveAll(empData);
        System.out.println(empData);
        return ResponseEntity.ok("Data Saved");
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployeeListWithEqualSalary(){


        return employeeRepository.getEmployees().
                stream().filter
                        (salary->salary.getSalary()==58000).
                collect(Collectors.toList());
    }

    @GetMapping("/filterEmployee")
    public Long filterEmployee(){

        return employeeRepository.getEmployees().stream().collect(Collectors.summingLong(salary->salary.getSalary()));

    }
    @GetMapping("subsetEmployee")
    public Map<Long,String> subsetEmployee(){
        return employeeRepository.getEmployees().stream().collect(Collectors.toMap(employee -> employee.getEmpId(),employee->employee.getName()));
    }

    @GetMapping("/getAddress")
    public List<Address> getFullAddress(){
        return addressRepository.getAddress();
    }
}
