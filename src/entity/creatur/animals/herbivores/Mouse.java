package entity.creatur.animals.herbivores;

import configuration.BiologicalType;
import entity.creatur.plants.Plant;
import entity.island.Location;

public class Mouse extends Herbivore {
    public Mouse(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        addPreyProbability(Caterpillar.class,0.9);
    }


}
