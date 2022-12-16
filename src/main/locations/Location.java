package main.locations;

public abstract class Location {
    protected String name;

    protected Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
