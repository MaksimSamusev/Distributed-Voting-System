package by.vote.data.service;

import java.util.List;

import by.vote.data.entity.Vote;

public interface VoteService {

	Vote create(Vote vote);

	Vote getOne(long id);

	Vote update(Vote vote);

	void delete(long id);

	List<Vote> getAll();

	void deleteAll();
}
