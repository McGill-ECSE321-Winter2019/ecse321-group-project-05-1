package ca.mcgill.ecse321.cooperator.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.model.EmployerContract;

@Transactional
@Repository
public interface EmployerContractRepository extends CrudRepository<EmployerContract, Integer> {
	public EmployerContract findEmployerContractById(int id);
	public EmployerContract deleteEmployerContractById(int id);
	
}
