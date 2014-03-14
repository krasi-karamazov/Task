package kpk.dev.models;

/**
 * Created by krasimir.karamazov on 3/14/14.
 */
public class Worker extends EmployeeDecorator {

    private double mPoints;

    public Worker(Person person) {
        super(person);
    }

    @Override
    public String getFormattedName() {
        return null;
    }

    public double getPoints() {
        return mPoints;
    }

    public void setPoints(double points) {
        this.mPoints = points;
    }
}
