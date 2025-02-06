package entity.creatur.animals.predators;

import entity.creatur.animals.herbivores.*;
import configuration.BiologicalType;
import entity.island.Location;

public class Wolf extends Predator {

    public Wolf(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(Herbivore.class, 0.1);
        addPreyProbability(Deer.class, 0.15);
        addPreyProbability(Rabbit.class, 0.6);
        addPreyProbability(Mouse.class, 0.8);
        addPreyProbability(Goat.class, 0.6);
        addPreyProbability(Sheep.class, 0.7);
        addPreyProbability(WildBoar.class, 0.15);
        addPreyProbability(Buffalo.class, 0.10);
        addPreyProbability(Duck.class, 0.40);
    }
}
