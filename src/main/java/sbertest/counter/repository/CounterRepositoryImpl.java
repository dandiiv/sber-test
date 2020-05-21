package sbertest.counter.repository;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CounterRepositoryImpl implements CounterRepository {

    private Map<String, Integer> map = new ConcurrentHashMap<>();

    @Override
    public void createCounter(String name) {
        map.putIfAbsent(name, 0);
    }

    @Override
    public int increment(String name) {
        return map.merge(name, 1, Integer::sum);
    }

    @Override
    public int getCounter(String name) {
        return map.get(name);
    }

    @Override
    public void delete(String name) {
        map.remove(name);
    }

    @Override
    public long getSum() {
        return map.values().stream()
                .mapToInt(value -> value)
                .sum();
    }

    @Override
    public List<String> getNames() {
        return new ArrayList<>(map.keySet());
    }
}
