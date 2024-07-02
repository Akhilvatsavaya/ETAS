package com.yantranet.etas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yantranet.etas.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{}