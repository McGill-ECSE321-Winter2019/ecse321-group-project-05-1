package ca.mcgill.ecse321.cooperator.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.model.Coop;

@Transactional
@Repository
public interface CoopRepository extends CrudRepository<Coop, Integer> {
	public Coop findBycoopID(int coopID);
	public Coop deleteBycoopID(int coopID);
}
