package sbertest.counter.controler;

import sbertest.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final CounterService counterService;

    @Autowired
    public MainController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/counter/{name}")
    public Integer getCounter(@PathVariable String name) {
        return counterService.getCounter(name);
    }

    @PostMapping("/counter/{name}")
    public void createCounter(@PathVariable String name) {
        counterService.createCounter(name);
    }

    @PutMapping("/counter/{name}")
    public Integer incrementByName(@PathVariable String name) {
        return counterService.incrementCounter(name);
    }

    @DeleteMapping("/counter/{name}")
    public void deleteCounter(@PathVariable String name) {
        counterService.deleteCounter(name);
    }

    @GetMapping("/counters")
    List<String> getAllCounters() {
        return counterService.getNamesOfAllCounter();
    }

    @GetMapping("/counters/sum")
    Long getSum() {
        return counterService.getSumOfAllCounter();
    }
}
