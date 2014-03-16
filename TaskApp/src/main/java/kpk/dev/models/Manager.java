package kpk.dev.models;

/**
 * Created by krasimir.karamazov on 3/14/14.
 */
public class Manager extends EmployeeDecorator {

    private int mNumberSubbordinates = 0;
    public Manager(Person person) {
        super(person);
    }

    public void setNumberOfSubordinates(int numSubordinates) {
        mNumberSubbordinates = numSubordinates;
    }

    public int getNumberOfSubordinates() {
        return mNumberSubbordinates;
    }

    @Override
    public String getHTMLFormattedName() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getFirstName());
        builder.append(" ");
        boolean toColor = false;
        if(mNumberSubbordinates > 20){
            builder.append("<font color='#00FF00'>");
            toColor = true;
        }

        builder.append(getLastName());

        if(toColor){
            builder.append("</font>");
        }

        return builder.toString();
    }
}
