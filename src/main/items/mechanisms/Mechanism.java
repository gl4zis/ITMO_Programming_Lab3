package main.items.mechanisms;

import main.items.Item;

public abstract class Mechanism extends Item {
    private StatusOfMechanism mechanismStatus;

    protected Mechanism(String name, StatusOfMechanism status) {
        super(name);
        this.mechanismStatus = status;
    }

    public StatusOfMechanism getStatus() {
        return mechanismStatus;
    }

    public void setStatus(StatusOfMechanism status) {
        mechanismStatus = status;
    }
}
