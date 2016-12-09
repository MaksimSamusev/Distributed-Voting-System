package by.center.data.service;

import java.util.List;

import by.center.data.entity.Statistic;

public interface StatisticService {

	Statistic create(Statistic statistic);

	Statistic read(long id);

	Statistic update(Statistic statistic);
    
    List<Statistic> getAll();

    void delete(long id);
}
