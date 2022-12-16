package main.other;

import main.alive.Alive;
import main.alive.Human;
import main.items.Item;
import main.items.mechanisms.rocket.Rocket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Module {
    private final int id = (int) (Math.random() * 1000);
    private final String name;
    private final ArrayList<Item> items = new ArrayList<Item>();
    private final ArrayList<Alive> crew = new ArrayList<Alive>();
    private Rocket rocket;

    public Module(String name) {
        this.name = name;
    }

    public void addCrew(Alive... h) {
        crew.addAll(Arrays.stream(h).toList());
        for (int i = 0; i < h.length; i++) {
            h[i].setLocation(this);
        }
    }

    public void deleteCrew(Alive... h) {
        crew.remove(h);
    }

    public void addItem(Item... item) {
        items.addAll(Arrays.stream(item).toList());
        for (int i = 0; i < item.length; i++) {
            item[i].setLocation(this);
        }
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket r) {
        this.rocket = r;
    }

    public List<Alive> getCrew() {
        return crew.stream().toList();
    }

    @Override
    public String toString(){
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
            return (((Module) b).id == id && Objects.equals(name, b.toString()));
        } else {
            return false;
        }
    }
}