package ca.mcgill.ecse321.cooperator.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.model.Evaluation;

@Transactional
@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
	public Evaluation findEvaluationById(int evaluationId);
	public Evaluation deleteEvaluationById(int evaluationId);
}
