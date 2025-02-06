package entity.creatur.animals.herbivores;


import entity.creatur.animals.Animal;
import entity.creatur.plants.Plant;
import configuration.BiologicalType;
import entity.island.Location;
import util.Randomizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
// Все травоядные могут съесть 100%
// Мышь, Кабан, Утка могут с вероятностью 90% съесть гусеницу
// Кабан могут с вероятностью 50% съесть мышь

public class Herbivore extends Animal {
    protected Map<Class<? extends Animal>, Double> preyHerbivores;

    public Herbivore(BiologicalType biologicalType, Location location) {
        super(biologicalType, location);
        preyHerbivores = new HashMap<>();
    }

    public void addPreyProbability(Class<? extends Animal> preyClass, double probability) {
        preyHerbivores.put(preyClass, probability);
    }

    @Override
    public void eat() {
        super.eat();
        Double saturation = 0d;
        if (this instanceof Duck || this instanceof Mouse || this instanceof WildBoar && ThreadLocalRandom.current().nextDouble() < 0.2) {
            int i = 3;
            while (i >= 0) {
                Class clazz = Randomizer.getRandomKey(preyHerbivores);
                try {
                    if (creatureLocation.creatureMap.get(clazz).get(i).isDead() && creatureLocation.creatureMap.get(clazz).isEmpty()) {
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (NullPointerException e) {
                }
                double probability = preyHerbivores.get(clazz);
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
                    } catch (NullPointerException e) {}
                    catch (ArrayIndexOutOfBoundsException e) {}


                } else {
                    //потратить энергию
                    this.setWeight(this.getWeight() - this.getWeightMax() * 0.3);
                    i--;
                }
            }
        }
        for (int j = 0; j < creatureLocation.creatureMap.get(Plant.class).size(); j++) {
            if (this.getWeight() + creatureLocation.creatureMap.get(Plant.class).get(j).getWeight() >= this.getWeightMax()) {
                break;
            } else {
                if (saturation != this.getMaximumSaturation()) {
                    saturation += creatureLocation.creatureMap.get(Plant.class).get(j).getWeight();
                    this.setWeight(this.getWeight() + creatureLocation.creatureMap.get(Plant.class).get(j).getWeight());
                    creatureLocation.creatureMap.get(Plant.class).get(j).setDead(true);
                    --j;
                } else {
                    break;
                }
            }
        }
        this.setWeight(this.getWeight() - this.getWeightMax() * 0.2);
    }
}

