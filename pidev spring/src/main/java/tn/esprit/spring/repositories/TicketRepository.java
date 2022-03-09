package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value="SELECT employee_id FROM `ticket` WHERE filedb_id IS NULL AND (DATEDIFF( datelimite, NOW())=1)",nativeQuery=true)
List<Object[]> alert();
////liste des employees qui n'ont pas remis leurs travaux
@Query(value="SELECT employee_id FROM `ticket` WHERE filedb_id IS NULL AND datelimite<NOW()",nativeQuery=true)
List<Object[]> nonremis();
}
