package by.vote.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.vote.data.entity.Vote;
import by.vote.data.repository.VoteRepository;
import by.vote.data.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;

	@Override
	public Vote create(Vote vote) {
		return voteRepository.saveAndFlush(vote);
	}

	@Override
	public Vote getOne(long id) {
		return voteRepository.findOne(id);
	}

	@Override
	public List<Vote> getAll() {
		return voteRepository.findAll();
	}

	@Override
	public Vote update(Vote vote) {
		voteRepository.deleteAll();
		return voteRepository.saveAndFlush(vote);
	}

	@Override
	public void delete(long id) {
		voteRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		voteRepository.deleteAll();
	}
}
