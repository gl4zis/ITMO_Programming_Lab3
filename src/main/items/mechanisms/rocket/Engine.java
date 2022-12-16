package main.items.mechanisms.rocket;

import main.items.mechanisms.Mechanism;
import main.items.mechanisms.StatusOfMechanism;

public class Engine extends Mechanism {
    private String sound;

    public Engine(String name, StatusOfMechanism status) {
        super(name, status);
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

}
