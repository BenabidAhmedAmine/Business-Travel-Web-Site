package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
