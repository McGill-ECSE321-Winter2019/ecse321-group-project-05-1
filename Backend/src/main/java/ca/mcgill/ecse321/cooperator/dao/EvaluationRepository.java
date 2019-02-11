package ca.mcgill.ecse321.cooperator.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.model.Evaluation;

public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
	public Evaluation findEvaluationById(int evaluationId);
}
