package util;

import configuration.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public Randomizer() {

    }

    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static Double random(Double min, Double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    public static <K, V> K getRandomKey(Map<K, V> map) {
        if (map.isEmpty()) {
            return null; // Если карта пуста, возвращаем null
        }
        // Преобразуем набор ключей в список
        List<K> keys = new ArrayList<>(map.keySet());

        // Генерируем случайный индекс
        Random random = new Random();
        int randomIndex = random.nextInt(keys.size());

        // Возвращаем ключ по случайному индексу
        return keys.get(randomIndex);
    }

    public static Direction getRandomDirection() {
        return Direction.values()[ThreadLocalRandom.current().nextInt(0, Direction.values().length - 1)];
    }
}
