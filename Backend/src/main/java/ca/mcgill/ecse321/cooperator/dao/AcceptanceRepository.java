package ca.mcgill.ecse321.cooperator.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.model.Acceptance;

@Transactional
@Repository
public interface AcceptanceRepository extends CrudRepository<Acceptance, Integer> {
	public Acceptance findAcceptanceById(int jobId);
}
