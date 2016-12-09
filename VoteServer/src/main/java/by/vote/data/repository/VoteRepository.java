package by.vote.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.vote.data.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
