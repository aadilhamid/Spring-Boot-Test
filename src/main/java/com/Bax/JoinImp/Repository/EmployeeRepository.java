package com.Bax.JoinImp.Repository;

import com.Bax.JoinImp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
    @Query(value="select * from employee order by salary",nativeQuery = true)
    List<Employee> getEmployees();

}
