package tn.esprit.spring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.ERole;
import tn.esprit.spring.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
