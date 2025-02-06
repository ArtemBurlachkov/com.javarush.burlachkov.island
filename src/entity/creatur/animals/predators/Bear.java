package entity.creatur.animals.predators;


import entity.creatur.animals.herbivores.*;
import configuration.BiologicalType;
import entity.island.Location;

public class Bear extends Predator {
    public Bear(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(BoaConstrictor.class, 0.8);
        addPreyProbability(Herbivore.class, 0.4);
        addPreyProbability(Deer.class, 0.8);
        addPreyProbability(Rabbit.class, 0.8);
        addPreyProbability(Mouse.class, 0.9);
        addPreyProbability(Goat.class, 0.7);
        addPreyProbability(Sheep.class, 0.7);
        addPreyProbability(WildBoar.class, 0.50);
        addPreyProbability(Buffalo.class, 0.20);
        addPreyProbability(Duck.class, 0.10);
    }
}
