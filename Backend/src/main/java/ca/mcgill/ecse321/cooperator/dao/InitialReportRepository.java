package ca.mcgill.ecse321.cooperator.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.model.InitialReport;

@Transactional
@Repository
public interface InitialReportRepository extends CrudRepository<InitialReport, Integer> {
	public InitialReport findInitialReportById(int id);
	public InitialReport deleteInitialReportById(int id);
}
