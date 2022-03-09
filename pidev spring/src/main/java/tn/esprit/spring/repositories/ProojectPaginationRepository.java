package tn.esprit.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import tn.esprit.spring.entities.Project;

public interface ProojectPaginationRepository extends PagingAndSortingRepository<Project , Long>{

}
