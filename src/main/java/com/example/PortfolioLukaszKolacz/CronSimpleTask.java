package com.example.PortfolioLukaszKolacz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 10.06.2017.
 */
@Component
public class CronSimpleTask {

    @Autowired
    ProjectRepository projectRepository;

    // s m g d m d
    // * - każda
    // / - co ileś
    @Scheduled(cron = "0 0 17-21 * * MON-FRI") // 20.30, 21, 21.30, 22
    public void printSomething() {
        System.out.println("HELLLOOOO!");
    }
}
