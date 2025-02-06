package entity.island;

import java.util.Random;

public class StatService implements Runnable {
    private int loop = 1;
    private Island island;

    public StatService(Island island) {
        this.island = island;

    }

    @Override
    public void run() {
        System.out.println("\rДень: " + loop++);
        getStat();
    }

    private void getStat() {
        Location locations[][] = island.getLocations();
        for (Location[] location : locations) {
            for (Location loc : location) {
                island.resetStatistics();
                loc.lock.unlock();
            }
        }
    }
}
