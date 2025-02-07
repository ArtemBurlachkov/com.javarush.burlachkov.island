package entity.island;

import configuration.Direction;
import configuration.Settings;
import entity.creatur.Creature;
import entity.creatur.animals.herbivores.*;
import entity.creatur.animals.predators.*;
import entity.creatur.plants.Plant;
import configuration.BiologicalType;
import util.CreatureFactory;
import util.Randomizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;


public class Location {

    private CopyOnWriteArrayList<Creature> wolfesInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> boaConstrictorsInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> foxesInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> bearsInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> eaglesInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> horsesInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> deersInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> rabbitsInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> mousesInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> goatsInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> sheepsInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> wildBoarsInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> buffalosInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> ducksInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> caterpillarsInLocation = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Creature> plantsInLocation = new CopyOnWriteArrayList<>();

    public List<Creature> creatures;
    private int rows;
    private int columns;
    private Island island;
    public ReentrantLock lock;
    public Map<Class, CopyOnWriteArrayList<Creature>> creatureMap = new HashMap<>();
    public Map<Class, CopyOnWriteArrayList<Creature>> newCreatureMap = new HashMap<>();
    BiologicalType biologicalType;
    Location location;

    protected Location(Island island, int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.island = island;
        location = this;
        lock = new ReentrantLock();
        initializationType();
    }

    public Map<Class, CopyOnWriteArrayList<Creature>> getCreatureMap() {
        return creatureMap;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Island getIsland() {
        return island;
    }

    private void initializationType() {
        CreatureFactory creatureFactory = new CreatureFactory();
        for (int i = 0; i < Randomizer.random(5, BiologicalType.WOLF.getMaxValueOnLocation()); i++) {
            wolfesInLocation.add(creatureFactory.creatureAnimal(BiologicalType.WOLF, this));
        }
        creatureMap.put(Wolf.class, wolfesInLocation);

        for (int i = 0; i < Randomizer.random(5, BiologicalType.BOA_CONSTRICTOR.getMaxValueOnLocation()); i++) {
            boaConstrictorsInLocation.add((BoaConstrictor) creatureFactory.creatureAnimal(BiologicalType.BOA_CONSTRICTOR, this));
        }
        creatureMap.put(BoaConstrictor.class, boaConstrictorsInLocation);

        for (int i = 0; i < Randomizer.random(5, BiologicalType.FOX.getMaxValueOnLocation()); i++) {
            foxesInLocation.add((Fox) creatureFactory.creatureAnimal(BiologicalType.FOX, this));
        }
        creatureMap.put(Fox.class, foxesInLocation);

        for (int i = 0; i < Randomizer.random(5, BiologicalType.BEAR.getMaxValueOnLocation()); i++) {
            bearsInLocation.add((Bear) creatureFactory.creatureAnimal(BiologicalType.BEAR, this));
        }
        creatureMap.put(Bear.class, bearsInLocation);

        for (int i = 0; i < Randomizer.random(5, BiologicalType.EAGLE.getMaxValueOnLocation()); i++) {
            eaglesInLocation.add((Eagle) creatureFactory.creatureAnimal(BiologicalType.EAGLE, this));
        }
        creatureMap.put(Eagle.class, eaglesInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.HORSE.getMaxValueOnLocation()); i++) {
            horsesInLocation.add((Horse) creatureFactory.creatureAnimal(BiologicalType.HORSE, this));
        }
        creatureMap.put(Horse.class, horsesInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.DEER.getMaxValueOnLocation()); i++) {
            deersInLocation.add((Deer) creatureFactory.creatureAnimal(BiologicalType.DEER, this));
        }
        creatureMap.put(Deer.class, deersInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.RABBIT.getMaxValueOnLocation()); i++) {
            rabbitsInLocation.add((Rabbit) creatureFactory.creatureAnimal(BiologicalType.RABBIT, this));
        }
        creatureMap.put(Rabbit.class, rabbitsInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.MOUSE.getMaxValueOnLocation()); i++) {
            mousesInLocation.add((Mouse) creatureFactory.creatureAnimal(BiologicalType.MOUSE, this));
        }
        creatureMap.put(Mouse.class, mousesInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.GOAT.getMaxValueOnLocation()); i++) {
            goatsInLocation.add((Goat) creatureFactory.creatureAnimal(BiologicalType.GOAT, this));
        }
        creatureMap.put(Goat.class, goatsInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.SHEEP.getMaxValueOnLocation()); i++) {
            sheepsInLocation.add((Sheep) creatureFactory.creatureAnimal(BiologicalType.SHEEP, this));
        }
        creatureMap.put(Sheep.class, sheepsInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.WILD_BOARD.getMaxValueOnLocation()); i++) {
            wildBoarsInLocation.add((WildBoar) creatureFactory.creatureAnimal(BiologicalType.WILD_BOARD, this));
        }
        creatureMap.put(WildBoar.class, wildBoarsInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.BUFFALO.getMaxValueOnLocation()); i++) {
            buffalosInLocation.add((Buffalo) creatureFactory.creatureAnimal(BiologicalType.BUFFALO, this));
        }
        creatureMap.put(Buffalo.class, buffalosInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.DUCK.getMaxValueOnLocation()); i++) {
            ducksInLocation.add((Duck) creatureFactory.creatureAnimal(BiologicalType.DUCK, this));
        }
        creatureMap.put(Duck.class, ducksInLocation);

        for (int i = 0; i < Randomizer.random(10, BiologicalType.CATERPILLAR.getMaxValueOnLocation()); i++) {
            caterpillarsInLocation.add((Caterpillar) creatureFactory.creatureAnimal(BiologicalType.CATERPILLAR, this));
        }
        creatureMap.put(Caterpillar.class, caterpillarsInLocation);

        for (int i = 0; i < Randomizer.random(199, BiologicalType.PLANT.getMaxValueOnLocation()); i++) {
            plantsInLocation.add((Plant) creatureFactory.creatureAnimal(BiologicalType.PLANT, this));
        }
        creatureMap.put(Plant.class, plantsInLocation);
    }

    public HashMap<String, Integer> getQuantityTypeBiologicals() {
        HashMap<String, Integer> biologicals = new HashMap<>();
        biologicals.put(String.valueOf(BiologicalType.WOLF.getIcon()), wolfesInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.BOA_CONSTRICTOR.getIcon()), boaConstrictorsInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.FOX.getIcon()), foxesInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.BEAR.getIcon()), bearsInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.EAGLE.getIcon()), eaglesInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.HORSE.getIcon()), horsesInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.DEER.getIcon()), deersInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.RABBIT.getIcon()), rabbitsInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.MOUSE.getIcon()), mousesInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.GOAT.getIcon()), goatsInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.SHEEP.getIcon()), sheepsInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.WILD_BOARD.getIcon()), wildBoarsInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.BUFFALO.getIcon()), buffalosInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.DUCK.getIcon()), ducksInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.DUCK.getIcon()), ducksInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.CATERPILLAR.getIcon()), caterpillarsInLocation.size());
        biologicals.put(String.valueOf(BiologicalType.PLANT.getIcon()), plantsInLocation.size());
        return biologicals;
    }


    public Location getNextLocation(Direction direction, int speed) {

        Location[][] locations = this.island.getLocations();

        for (int i = 0; i < speed; i++) {
            try {
                switch (direction) {

                    case UP -> {
                        if (getRows() < Settings.rowsCount - 1) {
                            return locations[getColumns()][getRows() + 1];
                        } else {
                            return locations[getColumns()][getRows()];
                        }
                    }

                    case DOWN -> {
                        if (rows > 0) {
                            return locations[getColumns()][getRows() - 1];
                        } else {
                            return null;
                        }
                    }

                    case LEFT -> {
                        if (columns > 0) {
                            return locations[columns - 1][getRows()];
                        } else {
                            return null;
                        }
                    }

                    case RIGHT -> {

                        if (getColumns() < Settings.columnsCount - 1) {
                            return locations[getColumns() + 1][getRows()];
                        } else {
                            return null;
                        }
                    }

                    default -> {
                        return null;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

        }
        return null;
    }

    public void growPlants() {
        CreatureFactory creatureFactory = new CreatureFactory();
        if (creatureMap.get(Plant.class).size() >= 0 && BiologicalType.PLANT.getMaxValueOnLocation() >= creatureMap.get(Plant.class).size()) {
            for (int i = 0; i < plantsInLocation.size() * .9 + 20; i++) {
                if (BiologicalType.PLANT.getMaxValueOnLocation() <= plantsInLocation.size()) {
                    break;
                }
                creatureMap.get(Plant.class).add(creatureFactory.creatureAnimal(BiologicalType.PLANT, this));

            }
        }

    }

    public boolean addCreature(Creature creature) {
        lock.lock();
        try {
            Class clazz = creature.getClass();
            if (creature.getMaxValueOnLocation() > this.creatureMap.get(clazz).size()) {
                this.creatureMap.get(clazz).add(creature);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return false;
    }

    public void removeCreature(Creature creature) {
        lock.lock();
        try {
            Class clazz = creature.getClass();
            if (creatureMap.get(clazz).contains(creature)) {
                creatureMap.get(clazz).remove(creature);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
