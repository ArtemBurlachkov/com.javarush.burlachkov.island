package entity.creatur.animals.predators;


import configuration.BiologicalType;
import entity.creatur.animals.Animal;
import entity.island.Location;
import util.Randomizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal {
    protected Map<Class<? extends Animal>, Double> preyProbabilities;


    public Predator(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        preyProbabilities = new HashMap<>();
    }

    public void addPreyProbability(Class<? extends Animal> preyClass, double probability) {
        preyProbabilities.put(preyClass, probability);
    }

    @Override
    public void eat() {
        super.eat();
        int i = 3;
        Double saturation = 0d;
        while (i >= 0) {
            Class clazz = Randomizer.getRandomKey(preyProbabilities);
            try {
                if (creatureLocation.creatureMap.get(clazz).get(i).isDead() && creatureLocation.creatureMap.get(clazz).isEmpty()) {
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            } catch (NullPointerException e) {
            }

            double probability = preyProbabilities.get(clazz);
            Random random = ThreadLocalRandom.current();
            if (random.nextDouble() < probability) {
                //насытиться
                //убить животное
                try {

                    if (creatureLocation.creatureMap.get(clazz).get(i).getWeight() >= this.getMaximumSaturation()) {
                        creatureLocation.creatureMap.get(clazz).get(i).setDead(true);
                        this.setWeight(this.getWeightMax());
                        break;
                    } else {
                        this.setWeight(this.getWeight() + creatureLocation.creatureMap.get(clazz).get(i).getWeight());
                        creatureLocation.creatureMap.get(clazz).get(i).setDead(true);
                        i--;
                    }
                } catch (NullPointerException e) {
                } catch (ArrayIndexOutOfBoundsException e) {
                }


            } else {
                //потратить энергию
                this.setWeight(this.getWeight() - this.getWeightMax() * 0.3);
                i--;
            }
        }

    }
}
