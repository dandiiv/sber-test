package sbertest.counter.service;

import java.util.List;

public interface CounterService {
    void createCounter(String name);

    int getCounter(String name);

    int incrementCounter(String name);

    void deleteCounter(String name);

    long getSumOfAllCounter();

    List<String> getNamesOfAllCounter();
}
