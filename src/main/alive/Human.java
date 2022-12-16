package main.alive;

import main.items.TransparentItem;
import main.items.Window;
import main.other.Seenable;
import main.other.Module;

import java.util.Objects;

public class Human implements Alive, Seenable {
    private final int id = (int) (Math.random() * 100);
    private final String name;
    private StatusOfHuman status;
    private Module location;

    public Human(String name, StatusOfHuman status) {
        this.name = name;
        this.status = status;
    }

    public void sleep() {
        status = StatusOfHuman.SLEEP;
        System.out.println(this + " заснул");
    }

    public void wakeUp() {
        status = StatusOfHuman.AWAKE;
        System.out.println(this + " проснулся");
    }

    public void think(String idea) {
        System.out.println(this + " подумал, что " + idea);
    }

    public void rejoice(String aboutWhat) {
        System.out.println(this + " обрадовался, что " + aboutWhat);
    }

    public void understand(String what, boolean success) {
        if (success) {
            System.out.println(this + " понял, что " + what);
        } else {
            System.out.println(this + " не понял, " + what);
        }
    }

    public void watch(Seenable onWhat) {
        System.out.println(this + " смотрит на " + onWhat);
    }

    public void watch(Seenable onWhat, TransparentItem throughWhat) {
        if (throughWhat.getLocation().equals(location)) {
            System.out.println(this + " смотрит через " + throughWhat + " на " + onWhat);
        }
    }

    public void watch(Window w) {
        if (w.getLocation().equals(location)) {
            System.out.println(this + " смотрит в " + w);
        }
    }

    public void hear(String sound) {
        System.out.println(this + " слышит: \"" + sound + "\"");
    }

    @Override
    public void setLocation(Module p) {
        location = p;
    }

    public void goTo(Module p) {
        if (status == StatusOfHuman.AWAKE) {
            if (location.getRocket().equals(p.getRocket()) && location != p) {
                System.out.println(this + " перешел из " + location + " в " + p);
                location.deleteCrew(this);
                p.addCrew(this);
            }
        }
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
            return (((Human) b).id == id && Objects.equals(name, b.toString()));
        } else {
            return false;
        }
    }
}
