package com.duong.ss03.repository;

import com.duong.ss03.model.dto.DisplayEmployeeDTO;
import com.duong.ss03.model.dto.EmployeeInfo;
import com.duong.ss03.model.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Optional<Employee> findEmployeeByPhone(String phone);

    @Query("""
            select new com.duong.ss03.model.dto.DisplayEmployeeDTO(e.id,e.name,e.email,e.phone,e.salary)
                         from Employee e
                         where e.salary >= :p_salary
            """)
    Page<DisplayEmployeeDTO> findEmployeesBySalary(@Param("p_status") Double salary, Pageable pageable);

    @Query("""
            select new com.duong.ss03.model.dto.DisplayEmployeeDTO(e.id,e.name,e.email,e.phone,e.salary) 
                        from Employee e
            """)
    Page<DisplayEmployeeDTO> getEmployees (Pageable pageable);

    @Query("""
            select e.name as name, e.phone as phone, e.salary as salary from Employee e
            """)
    List<EmployeeInfo> findAllEmployees ();


}
