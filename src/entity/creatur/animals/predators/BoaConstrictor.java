package entity.creatur.animals.predators;

import entity.creatur.animals.herbivores.*;
import configuration.BiologicalType;
import entity.island.Location;

public class BoaConstrictor extends Predator {
    public BoaConstrictor(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(Fox.class, 0.15);
        addPreyProbability(Rabbit.class, 0.2);
        addPreyProbability(Mouse.class, 0.4);
        addPreyProbability(Duck.class, 0.10);
    }
}
