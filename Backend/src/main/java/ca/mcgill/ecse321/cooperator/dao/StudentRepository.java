package ca.mcgill.ecse321.cooperator.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.model.Student;

@Transactional
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
	public Student findById(int id); 
	public Student deleteById(int id);
}
