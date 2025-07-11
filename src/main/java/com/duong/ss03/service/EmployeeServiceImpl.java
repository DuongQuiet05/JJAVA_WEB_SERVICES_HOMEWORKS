package com.duong.ss03.service;

import com.duong.ss03.model.dto.CreateEmployeeDTO;
import com.duong.ss03.model.dto.DisplayEmployeeDTO;
import com.duong.ss03.model.dto.PaginationDTO;
import com.duong.ss03.model.dto.UpdateEmployeeDTO;
import com.duong.ss03.model.entity.Employee;
import com.duong.ss03.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepo employeeRepo;

    @Override
    public PaginationDTO getPaginateDTO(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<DisplayEmployeeDTO> p = employeeRepo.getEmployees(pageable);
        PaginationDTO dto = new PaginationDTO();

        dto.setDisplayEmployeeDTOS(p.getContent());
        dto.setTotalPages(p.getTotalPages());
        dto.setTotalItems(p.getTotalElements());
        dto.setHasNext(p.hasNext());

        return dto;
    }

    @Override
    public boolean addEmployee(CreateEmployeeDTO dto) {
        try {
            employeeRepo.save(convertCreateToEntity(dto));
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public Employee convertCreateToEntity(CreateEmployeeDTO dto) {
        return new Employee(
                null,
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getSalary(),
                null
        );
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        return Optional.of(employeeRepo.findById(id)).orElse(Optional.empty());
    }

    @Override
    public boolean editEmployee(UpdateEmployeeDTO dto) {
        Optional<Employee> employeeOptional = employeeRepo.findById(dto.getId());
        if(employeeOptional.isEmpty()) return false;

        Employee old = employeeOptional.get();
        old.setName(dto.getName());
        old.setEmail(dto.getEmail());
        old.setPhone(dto.getPhone());
        old.setSalary(dto.getSalary());

        try {
            employeeRepo.save(old);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }


    @Override
    public boolean deleteEmployeeById(int id) {
        try {
            employeeRepo.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }
}
