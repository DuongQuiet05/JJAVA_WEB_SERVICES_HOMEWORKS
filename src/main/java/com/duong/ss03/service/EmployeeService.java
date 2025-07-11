package com.duong.ss03.service;

import com.duong.ss03.model.dto.CreateEmployeeDTO;
import com.duong.ss03.model.dto.DisplayEmployeeDTO;
import com.duong.ss03.model.dto.PaginationDTO;
import com.duong.ss03.model.dto.UpdateEmployeeDTO;
import com.duong.ss03.model.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
   PaginationDTO getPaginateDTO (int page, int size);
   boolean addEmployee (CreateEmployeeDTO dto);
   Employee convertCreateToEntity (CreateEmployeeDTO dto);

   Optional<Employee> findEmployeeById (int id);
   boolean editEmployee (UpdateEmployeeDTO dto);


   boolean deleteEmployeeById (int id);


}
