package ca.mcgill.ecse321.cooperator.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.cooperator.model.Person;

@Repository
public class CooperatorRepository {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public Person createPerson(String name) {
		Person p = new Person();
		p.setName(name);
		entityManager.persist(p);
		return p;
	}

	@Transactional
	public Person getPerson(String name) {
		Person p = entityManager.find(Person.class, name);
		return p;
	}

}
