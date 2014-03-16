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
    public String getHTMLFormattedName() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getFirstName());
        builder.append(" ");
        boolean toColor = false;
        if(mPoints < 2.8){
            builder.append("<font color='#FF0000'>");
            toColor = true;
        }

        builder.append(getLastName());

        if(toColor){
            builder.append("</font>");
        }


        return builder.toString();
    }

    public double getPoints() {
        return mPoints;
    }

    public void setPoints(double points) {
        this.mPoints = points;
    }

    @Override
    public String getReadableData() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Points:");
        builder.append(mPoints);
        return builder.toString();
    }
}
