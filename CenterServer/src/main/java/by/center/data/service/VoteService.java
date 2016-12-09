package by.center.data.service;

import java.util.List;

import by.center.data.entity.Vote;

public interface VoteService {

    Vote create(Vote vote);

    Vote read(long id);

    Vote update(Vote vote);
    
    List<Vote> getAll();

    void delete(long id);

	void deleteAll();
}
