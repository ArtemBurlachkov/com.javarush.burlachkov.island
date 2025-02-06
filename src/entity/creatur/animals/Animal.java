package entity.creatur.animals;

import configuration.Direction;
import entity.creatur.Creature;
import configuration.BiologicalType;
import entity.creatur.animals.herbivores.Caterpillar;
import entity.island.Location;
import util.CreatureFactory;
import util.Randomizer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Creature {
    public Animal(BiologicalType type, Location location) {
        super(type, location);
    }

    public void eat() {
        if (this instanceof Caterpillar) {
            return;
        }
        if (this.isDead()) {
//            System.out.println("You are dead!");
            return;
        }
        if (this.getWeight() >= this.getWeightMax() * 0.7) {
//            System.out.print("You are out of weight! ");
            return;
        }
        if (this.getWeight() < this.getWeightMax()/2) {
            this.setDead(true);
//            System.out.println("You are now dead!");
            return;
        }
    }

    public void move(Direction direction) {
        Location nextLocation = null;
            int currentSpeed;
            if(this.getMove() !=0) {
                currentSpeed = ThreadLocalRandom.current().nextInt(0, this.getMove());
            } else {
                currentSpeed = 0;

            }

            Location currentLocation = this.creatureLocation;
            nextLocation = currentLocation.getNextLocation(direction, currentSpeed);

            if (nextLocation != null){
                if(nextLocation.addCreature(this)){
                    currentLocation.removeCreature(this);
                }
            }


    }

    public void reproduce() {
        Map<Class, CopyOnWriteArrayList<Creature>> creatureMap = this.creatureLocation.creatureMap;
        CopyOnWriteArrayList<Creature> newCreatures = new CopyOnWriteArrayList<>();
        Class<? extends Creature> s = this.getClass();
        List<Creature> list = creatureMap.get(s);
        Animal animal = null;
        CreatureFactory creatureFactory = new CreatureFactory();
        if (list.size() > 1){
            int creatureCount = 0;

            if (this.creatureLocation.newCreatureMap.get(this.getClass()) != null){
                creatureCount = (this.creatureLocation.creatureMap.get(this.getClass()).size() + this.creatureLocation.newCreatureMap.get(this.getClass()).size());
            } else {
                creatureCount = this.creatureLocation.creatureMap.get(this.getClass()).size();
            }
            if  ( creatureCount < this.getMaxValueOnLocation()) {
                try {
                    if(ThreadLocalRandom.current().nextInt() < 0.1) {
                        animal = (Animal) creatureFactory.creatureAnimal(getBiologicalType(), creatureLocation);
                        this.creatureLocation.creatureMap.get(this.getClass()).add(animal);
                     //   System.out.println(animal);
                    }
                } catch (Exception e){
                    animal = null;
                }
            }
        }
    }


}
