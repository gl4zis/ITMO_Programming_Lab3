package main.locations;

import main.alive.Human;
import main.other.Seenable;

import java.util.Objects;

public class Planet extends Location implements Seenable {
    private final int size;
    private final int mass;

    public Planet(String name, int size, int mass) {
        super(name);
        this.size = size;
        this.mass = mass;
    }

    @Override
    public int hashCode() {
        return name.hashCode()*10;
    }

    @Override
    public boolean equals(Object b) {
        if (b == this) {
            return true;
        }
        else if (b == null) {
            return false;
        }
        else if (b.getClass() == this.getClass()) {
            return (Objects.equals(name, b.toString()));
        } else {
            return false;
        }
    }
}
