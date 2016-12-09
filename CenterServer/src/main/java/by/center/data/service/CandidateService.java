package by.center.data.service;

import java.util.List;

import by.center.data.entity.Candidate;



public interface CandidateService {

	Candidate create(Candidate candidate);

	Candidate read(long id);
	
	Boolean check(String candidate);

	Candidate update(Candidate candidate);
	
	List<Candidate> getAll();	

    void delete(long id);
}
