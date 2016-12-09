package by.center.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.center.data.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
