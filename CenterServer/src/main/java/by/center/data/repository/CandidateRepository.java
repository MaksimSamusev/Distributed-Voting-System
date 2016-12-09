package by.center.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.center.data.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
