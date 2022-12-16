package main.alive;

import main.other.Module;

public interface Alive {
    void setLocation(Module p);

    @Override
    String toString();

}
