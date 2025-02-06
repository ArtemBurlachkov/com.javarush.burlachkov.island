package entity.creatur.animals.predators;

import entity.creatur.animals.herbivores.Duck;
import entity.creatur.animals.herbivores.Mouse;
import entity.creatur.animals.herbivores.Rabbit;
import configuration.BiologicalType;
import entity.island.Location;

public class Fox extends Predator {
    public Fox(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(Rabbit.class, 0.7);
        addPreyProbability(Mouse.class, 0.9);
        addPreyProbability(Duck.class, 0.6);
    }
}
