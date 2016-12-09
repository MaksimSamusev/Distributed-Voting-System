package by.center.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.center.data.entity.Vote;
import by.center.data.repository.VoteRepository;
import by.center.data.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository matchRepository;

    @Override
    public Vote create(Vote vote) {
        return matchRepository.saveAndFlush(vote);
    }

    @Override
    public Vote read(long id) {
        return matchRepository.findOne(id);
    }

    @Override
    public Vote update(Vote vote) {
        return matchRepository.saveAndFlush(vote);
    }

    @Override
    public void delete(long id) {
        matchRepository.delete(id);
    }
    
    @Override
	public List<Vote> getAll() {
		return matchRepository.findAll();
	}

	@Override
	public void deleteAll() {
		 matchRepository.deleteAll();
	}
    
    

}
