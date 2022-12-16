package main.locations;

public class Space extends Location {

    public Space() {
        super("космос");
    }

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public boolean equals(Object b) {
        return (b.getClass() == this.getClass());
    }
}
