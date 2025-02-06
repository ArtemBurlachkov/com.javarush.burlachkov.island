package util;

import configuration.BiologicalType;
import entity.creatur.Creature;
import entity.creatur.animals.herbivores.*;
import entity.creatur.animals.predators.*;
import entity.creatur.plants.Plant;
import entity.island.Location;

import static configuration.BiologicalType.*;

public class CreatureFactory {
    Creature creature = null;

    public Creature creatureAnimal(BiologicalType biologicalType, Location location ) {

        creature = switch (biologicalType) {
            //Хищники
            case WOLF -> new Wolf(WOLF, location);
            case BOA_CONSTRICTOR -> new BoaConstrictor(BOA_CONSTRICTOR, location);
            case FOX -> new Fox(FOX, location);
            case BEAR -> new Bear(BEAR, location);
            case EAGLE -> new Eagle(EAGLE, location);
            //Травоядные
            case HORSE -> new Horse(HORSE, location);
            case DEER -> new Deer(DEER, location);
            case RABBIT -> new Rabbit(RABBIT, location);
            case MOUSE -> new Mouse(MOUSE, location);
            case GOAT -> new Goat(GOAT, location);
            case SHEEP -> new Sheep(SHEEP, location);
            case WILD_BOARD -> new WildBoar(WILD_BOARD, location);
            case BUFFALO -> new Buffalo(BEAR, location);
            case DUCK -> new Duck(DEER, location);
            case CATERPILLAR -> new Caterpillar(CATERPILLAR, location);
            //Растение
            case PLANT -> new Plant(PLANT, location);
        };
        return creature;
    }
}

