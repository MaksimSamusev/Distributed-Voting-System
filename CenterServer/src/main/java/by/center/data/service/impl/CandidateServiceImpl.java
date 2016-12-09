package by.center.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.center.data.entity.Candidate;
import by.center.data.repository.CandidateRepository;
import by.center.data.service.CandidateService;




@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository matchRepository;

    @Override
    public Candidate create(Candidate candidate) {
        return matchRepository.saveAndFlush(candidate);
    }    
    
	@Override
	public Boolean check(String candidate) {
		boolean temp=false; 
		for(Candidate candidatee:matchRepository.findAll()){
			if(candidate.equals(candidatee.getCandidate())){
				temp= true;
			}			
		}		
		return temp;
	}

    @Override
    public Candidate read(long id) {
        return matchRepository.findOne(id);
    }
    
	@Override
	public List<Candidate> getAll() {
		return matchRepository.findAll();
	}
    @Override
    public Candidate update(Candidate vote) {
        return matchRepository.saveAndFlush(vote);
    }

    @Override
    public void delete(long id) {
        matchRepository.delete(id);
    }

}
