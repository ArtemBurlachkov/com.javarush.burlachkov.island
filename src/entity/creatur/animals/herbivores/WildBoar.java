package entity.creatur.animals.herbivores;

import configuration.BiologicalType;
import entity.island.Location;

public class WildBoar extends Herbivore {
    public WildBoar(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(Caterpillar.class,0.9);
        addPreyProbability(Mouse.class,0.5);
    }
}
