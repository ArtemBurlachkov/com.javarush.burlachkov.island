package entity.creatur.animals.herbivores;

import configuration.BiologicalType;
import entity.island.Location;

public class Duck extends Herbivore {

    public Duck(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(Caterpillar.class,0.9);
    }
}
