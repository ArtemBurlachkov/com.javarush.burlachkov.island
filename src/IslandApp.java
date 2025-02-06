import configuration.Settings;
import entity.island.Island;
import entity.island.Location;
import entity.island.StatService;
import services.StartGame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class IslandApp {
    public static void main(String[] args) {

        Island island = new Island(Settings.columnsCount, Settings.rowsCount);
        Location[][] locations = island.getLocations();
        StatService statService = new StatService(island);
        ExecutorService executorService = Executors.newFixedThreadPool(Settings.nTreads);
        StartGame startGame = new StartGame(executorService, locations, island, statService);
    }
}
