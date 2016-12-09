package by.center.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.center.data.entity.Candidate;
import by.center.data.entity.Statistic;
import by.center.data.repository.StatisticRepository;
import by.center.data.service.StatisticService;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository matchRepository;

    @Override
    public Statistic create(Statistic statistic) {
    	
		for(Statistic statist:matchRepository.findAll()){
			if(statist.getCandidate().equals(statistic.getCandidate())){
				 long temp=statist.getCountVote();
				 long tempt=statistic.getCountVote();
				 matchRepository.delete(statist.getId());
				 statistic.setCountVote(temp+tempt);;
			}			
		}		
		
        return matchRepository.saveAndFlush(statistic);
    }

    @Override
    public Statistic read(long id) {
        return matchRepository.findOne(id);
    }

    @Override
    public Statistic update(Statistic statistic) {
        return matchRepository.saveAndFlush(statistic);
    }

    @Override
    public void delete(long id) {
        matchRepository.delete(id);
    }
    
    @Override
	public List<Statistic> getAll() {
		return matchRepository.findAll();
	}

}
