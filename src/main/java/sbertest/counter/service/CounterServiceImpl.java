package sbertest.counter.service;

import org.springframework.beans.factory.annotation.Autowired;
import sbertest.counter.repository.CounterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {

    private final CounterRepository counterRepository;

    @Autowired
    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public void createCounter(String name) {
        counterRepository.createCounter(name);
    }

    @Override
    public int getCounter(String name) {
        return counterRepository.getCounter(name);
    }

    @Override
    public int incrementCounter(String name) {
        return counterRepository.increment(name);
    }

    @Override
    public void deleteCounter(String name) {
        counterRepository.delete(name);
    }

    @Override
    public long getSumOfAllCounter() {
        return counterRepository.getSum();
    }

    @Override
    public List<String> getNamesOfAllCounter() {
        return counterRepository.getNames();
    }
}
