package main;


import main.alive.Human;
import main.alive.StatusOfHuman;
import main.items.Item;
import main.items.SimpleItem;
import main.items.TransparentItem;
import main.items.Window;
import main.items.mechanisms.StatusOfMechanism;
import main.items.mechanisms.rocket.Engine;
import main.items.mechanisms.rocket.Rocket;
import main.items.mechanisms.rocket.StatusOfRocket;
import main.other.Route;
import main.other.Module;
import main.locations.Planet;
import main.locations.Space;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Space space = new Space();
        Planet mun = new Planet("Луна", 3475, 735);
        Planet earth = new Planet("Земля", 12742, 6000);
        Route dest1 = new Route(earth, mun);
        Human donut = new Human("Пончик", StatusOfHuman.SLEEP);
        Human dunno = new Human("Незнайка", StatusOfHuman.SLEEP);
        Window window = new Window("иллюминатор");
        Item bed = new SimpleItem("спальное место");
        Module upperModule = new Module("верхний отсек");
        Module lowerModule = new Module("нижний отсек");
        Engine mainEngine = new Engine("главный двигатель", StatusOfMechanism.WORK);
        Engine thruster = new Engine("поворотный двигатель", StatusOfMechanism.DISABLED);
        Rocket rocket = new Rocket("Ракета", StatusOfRocket.FLYING, space, mainEngine, thruster);
        rocket.getFlightComputer().setRoute(dest1);
        upperModule.addItem(window);
        lowerModule.addCrew(dunno, donut);
        lowerModule.addItem(bed);
        for (int i=0;i<rocket.engines.size();i++) lowerModule.addItem((Item) rocket.engines.get(i));
        rocket.addModule(lowerModule, upperModule);

        rocket.printStatus();
        System.out.println("-------------------------");
        rocket.setMaxSpeed();
        donut.wakeUp();
        dunno.wakeUp();
        dunno.goTo(upperModule);
        donut.think(mainEngine + " сломался");
        donut.rejoice(rocket + " возвращается");
        donut.goTo(upperModule);

        donut.watch(window);
        dunno.watch(window);
        donut.understand("движется ли " + rocket, false);
        dunno.understand("движется ли " + rocket, false);

        Engine secondEng = rocket.getFlightComputer().getEngines().get(1);
        rocket.turnAround();
        dunno.hear(secondEng.getSound());
        donut.hear(secondEng.getSound());
        dunno.watch(mun, window);
        donut.watch(mun, window);
    }
}