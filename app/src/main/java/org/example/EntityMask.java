package org.example;

public class EntityMask {

    public boolean age;
    public boolean name;
    public boolean weight;
    public boolean state;

    public static final int AGE = 1 << 3; // 1000
    public static final int NAME = 1 << 2; // 0100
    public static final int WEIGHT = 1 << 1; // 0010
    public static final int STATE = 1; // 0001

    public EntityMask(
        boolean age,
        boolean name,
        boolean weight,
        boolean state
    ) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.state = state;
    }

    public EntityMask() {
        this.age = false;
        this.name = false;
        this.weight = false;
        this.state = false;
    }

    public EntityMask(Integer mask) {
        this.age = (mask & AGE) != 0;
        this.name = (mask & NAME) != 0;
        this.weight = (mask & WEIGHT) != 0;
        this.state = (mask & STATE) != 0;
    }

    public Integer getIntMask() {
        int result = 0;
        if (this.age) result |= AGE;
        if (this.name) result |= NAME;
        if (this.weight) result |= WEIGHT;
        if (this.state) result |= STATE;
        return result;
    }
}
