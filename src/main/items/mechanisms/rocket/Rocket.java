package main.items.mechanisms.rocket;

import main.alive.Alive;
import main.items.mechanisms.Mechanism;
import main.items.mechanisms.StatusOfMechanism;
import main.locations.Location;
import main.other.Module;
import main.locations.Planet;

import java.util.ArrayList;
import java.util.Arrays;

public class Rocket extends Mechanism {
    private StatusOfRocket rocketStatus;
    private final FlightComputer flightComputer;
    private final Location location;
    private final ArrayList<Module> innerModules = new ArrayList<Module>();
    public ArrayList<Engine> engines = new ArrayList<Engine>();
    private boolean isMaxSpeed = false;
    private final ArrayList<Alive> crew = new ArrayList<Alive>();

    public Rocket(String name, StatusOfRocket rocketStatus, Location location, Engine... engines) {
        super(name, StatusOfMechanism.WORK);
        this.rocketStatus = rocketStatus;
        this.flightComputer = new FlightComputer("Электронная управляющая машина", StatusOfMechanism.WORK, this);
        this.location = location;
        if (rocketStatus == StatusOfRocket.CRASHED) {
            setStatus(StatusOfMechanism.BROKEN);
            this.flightComputer.setStatus(StatusOfMechanism.BROKEN);
        }
        for (int i=0;i<engines.length;i++) {
            this.engines.add(engines[i]);
            if (engines[i].getStatus() == StatusOfMechanism.BROKEN) {
                warning(engines[i]);
            }
        }
    }

    private void warning(Mechanism error) {
        System.out.println("!!!ОПАСНОСТЬ!!! НЕ исправен механизм: " + error);
        rocketStatus = StatusOfRocket.RETURNING;
    }

    public void crash() {
        rocketStatus = StatusOfRocket.CRASHED;
        warning(this);
    }

    public void printStatus() {
        System.out.println(name + " " + rocketStatus + ", " +
                "\nЛокация: " + location +
                "\nМаршрут: " + getFlightComputer().getRoute() +
                "\nОтсеки: " + innerModules +
                "\nДвигатели: " + engines +
                "\nЭкипаж: " + crew);
    }

    public void addModule(Module... m) {
        innerModules.addAll(Arrays.stream(m).toList());
        for (int i = 0; i < m.length; i++) {
            m[i].setRocket(this);
            crew.addAll(m[i].getCrew());
        }
    }

    public FlightComputer getFlightComputer() {
        return flightComputer;
    }

    public void setMaxSpeed() {
        if (rocketStatus == StatusOfRocket.FLYING) {
            isMaxSpeed = true;
            System.out.println(name + " достигла максимальной скорости");
            for (int i=0;i<engines.size();i++){
                flightComputer.setEngineStatus(i, StatusOfMechanism.DISABLED);
            }
            System.out.println("Все двигатели выключены\n" +
                    this + " " + rocketStatus);
        }
    }

    private Planet[] getSeenablePlanets() {
        return flightComputer.getRoute().getPlanets();
    }

    public void turnAround() {
        if (rocketStatus == StatusOfRocket.FLYING) {
            flightComputer.setEngineStatus(1, StatusOfMechanism.WORK);
            System.out.println(flightComputer.getEngines().get(1) + " " + flightComputer.getEngines().get(1).getStatus());
            System.out.println(name + " поворачивается");
            System.out.println(getSeenablePlanets()[0].toString() + " и " + getSeenablePlanets()[1].toString() + " вращаются");
        }
    }
}