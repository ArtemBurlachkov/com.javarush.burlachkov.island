package entity.creatur;

import configuration.BiologicalType;
import entity.island.Location;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Creature {
    private String icon;
    private Double weight;
    private final Integer maxValueOnLocation;
    private Integer move;
    private final Double weightMax;
    private boolean isDead;
    private final Double maximumSaturation;
    public Location creatureLocation;
    private BiologicalType biologicalType;

    ThreadLocalRandom randomizer = ThreadLocalRandom.current();

    protected Creature(BiologicalType type, Location location) {
        this.icon = String.valueOf(type.getIcon());
        this.weight = type.getMaxWeight()*0.8;
        this.maxValueOnLocation = type.getMaxValueOnLocation();
        this.move = type.getMovementSpeed();
        this.weightMax = type.getMaxWeight();
        this.isDead = false;
        this.creatureLocation = location;
        this.maximumSaturation = type.getMaximumSaturation();
        this.biologicalType = type;
    }

    public Location getCreatureLocation() {
        return creatureLocation;
    }

    public BiologicalType getBiologicalType() {
        return biologicalType;
    }

    public Double getMaximumSaturation() {
        return maximumSaturation;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getWeightMax() {
        return weightMax;
    }

    public Integer getMove() {
        return move;
    }

    public Integer getMaxValueOnLocation() {
        return maxValueOnLocation;
    }

    public String getIcon() {
        return icon;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void die() {
        Iterator<Map.Entry<Class, CopyOnWriteArrayList<Creature>>> iterator = creatureLocation.creatureMap.entrySet().iterator();
        while (iterator.hasNext()) {
            try {
                Map.Entry<Class, CopyOnWriteArrayList<Creature>> entry = iterator.next();
                Class key = entry.getKey();
                CopyOnWriteArrayList<Creature> creatures = entry.getValue();
                Iterator<Creature> creatureIterator = creatures.iterator();
                creatures.removeIf(creature -> creature.isDead());

            } catch (Exception e) {}
        }
    }
}
