package by.center.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.center.data.entity.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
