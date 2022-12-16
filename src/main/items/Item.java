package main.items;

import main.alive.Human;
import main.other.Seenable;
import main.locations.Location;
import main.other.Module;

import java.util.Objects;

public abstract class Item implements Seenable {
    private final int id = (int) (Math.random() * 10000);
    protected String name;
    private Module location;

    protected Item(String name) {
        this.name = name;
    }

    public Module getLocation() {
        return location;
    }

    public void setLocation(Module p) {
        location = p;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return id;
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
            return (((Item) b).id == id && Objects.equals(name, b.toString()));
        } else {
            return false;
        }
    }
}
