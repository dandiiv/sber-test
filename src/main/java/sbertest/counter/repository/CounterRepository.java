package sbertest.counter.repository;

import java.util.List;

public interface CounterRepository {
    void createCounter(String name);

    int increment(String name);

    int getCounter(String name);

    void delete(String name);

    long getSum();

    List<String> getNames();
}

