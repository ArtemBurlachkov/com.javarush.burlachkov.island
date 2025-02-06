package entity.creatur.animals.predators;

import entity.creatur.animals.herbivores.Duck;
import entity.creatur.animals.herbivores.Mouse;
import entity.creatur.animals.herbivores.Rabbit;
import configuration.BiologicalType;
import entity.island.Location;

public class Eagle extends Predator {
    public Eagle(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(Fox.class, 0.10);
        addPreyProbability(Rabbit.class, 0.9);
        addPreyProbability(Mouse.class, 0.9);
        addPreyProbability(Duck.class, 0.8);
    }
}
