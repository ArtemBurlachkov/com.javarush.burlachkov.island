package entity.creatur.plants;

import entity.creatur.Creature;
import configuration.BiologicalType;
import entity.island.Location;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Plant extends Creature {
    public Plant(BiologicalType type, Location location) {
        super(type, location);
    }



    // РОСТ РАСТЕНИЙ
    // void encreaseQuantity(){
    //       ++quantity
    //    }

}
