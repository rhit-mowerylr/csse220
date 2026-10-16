package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

/**
 * This class represents a Person who can either be healthy (green), infected (orange), or recovered (pink).
 * Once a Person becomes infected, they will remain infected for a certain length of time before they
 * become recovered. Once recovered, the Person cannot be infected again.
 * <p>
 * Inspired by this article: https://www.washingtonpost.com/graphics/2020/world/corona-simulator/
 * <p>
 * To visualize a population of Persons over time you should provide a method that says if a Person
 * isHealthy, isSick, or isRecovered.
 * <p>
 * <p>
 * This class should use inheritance to make it simple to write. You should not need to copy and paste
 * <p>
 * DONE: Part 4 You can change this file but will need to provide each of the methods started in order to get full
 * functionality.
 *
 * @author Luke Mowery
 *
 */
public class Person extends SimulationObject {

    public static final int PERSON_RADIUS = 10;
    public static final int PERSON_SPEED = 5;

    //How many timesteps to recover once infected
    public static final int TIME_TO_RECOVER = 100;


    public static final Color HEALTHY_COLOR = new Color(134, 184, 184);
    public static final Color INFECTED_COLOR = new Color(204, 102, 0);
    public static final Color RECOVERED_COLOR = new Color(196, 116, 195);

    //DONE: add instance variables
    public int status = 0;
    public int time_infected = 0;

    //DONE: add constructors
    public Person(int x, int y, int status) {
        super(x, y);
        this.status = status;
        this.setColor(HEALTHY_COLOR);
        this.setRadius(PERSON_RADIUS);
        this.setMoveSpeed(PERSON_SPEED);
        normalizeVelocity();
    }

    public void update(Dimension2D dim) {
        //DONE Update your position
        super.update(dim);
        this.setColor(HEALTHY_COLOR);
        if (this.isInfected()) {
            time_infected += 1;
            if (time_infected > TIME_TO_RECOVER) {
                status = 2;
            }
        }
    }

    public void bounce(Person other) {
        //DONE Infect healthy people when they bounce off of infected people
        super.bounce(other);
        if (other.isInfected() && this.isHealthy()) {
            status = 1;
        }
    }

    public boolean isHealthy() {
        // DONE return true if this person is healthy.  False if infected or recovered
        if (status == 0) {
            return true;
        }
        return false;
    }

    public boolean isInfected() {
        // DONE return true if this person is sick.  False if infected or recovered
        if (status == 1) {
            this.setColor(INFECTED_COLOR);
            return true;
        }
        return false;
    }

    public boolean isRecovered() {
        // DONE return true if this person is recovered.  False if infected or healthy
        if (status == 2) {
            this.setColor(RECOVERED_COLOR);
            return true;
        }
        return false;
    }

    public boolean overlapsWith(Person other) {
        // DONE return true if the person is within range of another
        return super.overlapsWith(other);
    }


}
