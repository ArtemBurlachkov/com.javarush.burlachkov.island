package entity.island;

import java.util.HashMap;

public class Island {

    private final int COLUMNS;
    private final int ROWS;
    public Location[][] locations;

    public Island(int columnsCount, int rowsCount) {
        this.COLUMNS = columnsCount;
        this.ROWS = rowsCount;
        initializationIsland();
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public int getROWS() {
        return ROWS;
    }

    private void initializationIsland() {
        locations = new Location[this.COLUMNS][this.ROWS];
        for (int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                Location location = new Location(this, column, row);
                locations[column][row] = location;
            }
        }
    }

    public void resetStatistics() {
        HashMap<String, Integer> result = new HashMap<>();
        HashMap<String, Integer>[] statistics = new HashMap[ROWS * COLUMNS];
        int index = 0;
        for (int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                statistics[index] = locations[column][row].getQuantityTypeBiologicals();
                index++;
            }
        }
        // Проходим по каждой карте
        for (HashMap<String, Integer> statistic : statistics) {
            // Проходим по каждой записи в текущей карте
            for (String key : statistic.keySet()) {
                // Если ключ уже есть в итоговой карте, добавляем значение
                // Если ключа нет, добавляем его с текущим значением
                result.put(key, result.getOrDefault(key, 0) + statistic.get(key));
            }
        }
        System.out.println("Итоговая статистика: " + result);
    }

    public Location[][] getLocations() {
        return locations;
    }
}
