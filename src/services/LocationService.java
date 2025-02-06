package services;


import configuration.Direction;
import entity.creatur.Creature;
import entity.creatur.animals.Animal;
import entity.creatur.plants.Plant;
import entity.island.Island;
import entity.island.Location;
import util.Randomizer;


import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


public class LocationService implements Runnable{
    private  Island island;
    private  Location location;
    public LocationService(Island island, Location location){
        this.island = island;
        this.location = location;
    }

    @Override
    public void run() {
        try {
            life();
        } catch (Exception e) {

        }
    }

    private void life() throws Exception {
        Set<Class> classes = location.creatureMap.keySet();
        location.growPlants();
        for(Class clazz: classes){
            for(Creature currentCreature: location.creatureMap.get(clazz)){
                if (currentCreature instanceof Animal) {
                    Animal animal = (Animal) currentCreature;
                    animal.eat();
                    animal.reproduce();
                    animal.move(Randomizer.getRandomDirection());
                    animal.die();
                }
            }
        }
    }
}

