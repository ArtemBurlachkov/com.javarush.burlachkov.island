package services;

import configuration.Settings;
import entity.island.Island;
import entity.island.Location;
import entity.island.StatService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class StartGame {

    public StartGame(ExecutorService executorService, Location[][] locations, Island island, StatService statService) {
        for (int i = 0; i < Settings.loops; i++) {
            List<Future<?>> futureList = new ArrayList<>();
            for(Location[] location : locations){
                for(Location cell : location){
                    futureList.add(executorService.submit(new LocationService(island, cell)));
                }
            }
            if (!futureList.isEmpty()) {
                while (!futureList.get(futureList.size()-1).isDone()) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                executorService.submit(statService);
            }
        }
        executorService.shutdown();
    }
}
