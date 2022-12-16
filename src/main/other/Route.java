package main.other;

import main.alive.Human;
import main.locations.Planet;

import java.util.Objects;

public class Route {
    private final Planet planet1;
    private final Planet planet2;
    private final String name;

    public Route(Planet planet1, Planet planet2) {
        this.name = planet1.toString() + " --> " + planet2.toString();
        this.planet1 = planet1;
        this.planet2 = planet2;
    }

    public Planet[] getPlanets() {
        Planet[] planets = new Planet[2];
        planets[0] = planet1;
        planets[1] = planet2;
        return planets;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return planet1.hashCode() - planet2.hashCode();
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
