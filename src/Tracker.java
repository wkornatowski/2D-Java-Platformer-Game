package project.test2;

import city.cs.engine.*;

import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 * *** I do not claim this as my own ***
 */
public class Tracker implements StepListener {
    /** The view */
    private UserView view;

    /** The body */
    private Body body;

    public Tracker(UserView view, Body body) {
        this.view = view;
        this.body = body;
    }

    /**
     */
    public void preStep(StepEvent e) {
    }

    /**
     */
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition()));
    }
    
}
