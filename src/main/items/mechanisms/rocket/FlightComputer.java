package main.items.mechanisms.rocket;

import main.items.mechanisms.Mechanism;
import main.items.mechanisms.StatusOfMechanism;
import main.other.Route;

import java.util.ArrayList;

public class FlightComputer extends Mechanism {
    private Route route;
    private final Rocket rocket;

    FlightComputer(String name, StatusOfMechanism status, Rocket rocket) {
        super(name, status);
        this.rocket = rocket;
    }

    public ArrayList<Engine> getEngines() {
        return rocket.engines;
    }

    public void setEngineStatus(int engineId, StatusOfMechanism newstatus) {
        Engine eng = rocket.engines.get(engineId);
        eng.setStatus(newstatus);
        engineStatusPrints(newstatus, eng);
    }

    private void engineStatusPrints(StatusOfMechanism status, Engine e) {
        if (status == StatusOfMechanism.WORK) {
            System.out.println(this + " включила " + e);
            e.setSound("Чаф-чаф-чаф-чаф!");
        } else {
            e.setSound("");
            if (status == StatusOfMechanism.DISABLED) {
                System.out.println(this + " выключила " + e);
            } else {
                System.out.println(e + " сломался");
            }
        }
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route d) {
        this.route = d;
    }
}
