package tn.esprit.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import tn.esprit.spring.entities.Employee;

public interface Employeesortrepository extends PagingAndSortingRepository<Employee, Long> {

}
