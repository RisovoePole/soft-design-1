package org.example;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EntityRepo {

    private ArrayList<Entity> db;

    public EntityRepo() {
        db = new ArrayList<>();
    }

    public void removeEntity(Entity entity) {
        db.remove(entity);
    }

    public void addEntity(Entity entity) {
        db.add(entity);
    }

    public ArrayList<Entity> getAllList() {
        return db;
    }

    public ArrayList<Entity> findByName(String name) {
        return db
            .stream()
            .filter(e -> e.name.equals(name))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Entity> findByMask(EntityMask mask, Entity entity) {
        int intMask = mask.getIntMask();

        Predicate<Entity> filter = e -> true;

        if ((intMask & EntityMask.AGE) != 0) {
            filter = filter.and(e -> e.age == entity.age);
        }
        if ((intMask & EntityMask.NAME) != 0) {
            filter = filter.and(e -> e.name.equals(entity.name));
        }
        if ((intMask & EntityMask.WEIGHT) != 0) {
            filter = filter.and(
                e -> Float.compare(e.weight, entity.weight) == 0
            );
        }
        if ((intMask & EntityMask.STATE) != 0) {
            filter = filter.and(e -> e.state == entity.state);
        }
        return db
            .stream()
            .filter(filter)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public int copyDataFromEntity(
        EntityMask copyMask,
        EntityMask findMask,
        Entity source
    ) {
        int cm = copyMask.getIntMask();
        if (cm == 0) return 0;

        ArrayList<Entity> found = findByMask(findMask, source);
        for (Entity e : found) {
            if ((cm & EntityMask.AGE) != 0) e.age = source.age;
            if ((cm & EntityMask.NAME) != 0) e.name = source.name;
            if ((cm & EntityMask.WEIGHT) != 0) e.weight = source.weight;
            if ((cm & EntityMask.STATE) != 0) e.state = source.state;
        }
        return found.size();
    }
}
