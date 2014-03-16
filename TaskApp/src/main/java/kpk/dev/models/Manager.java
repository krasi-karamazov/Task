package kpk.dev.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krasimir.karamazov on 3/14/14.
 */
public class Manager extends EmployeeDecorator {

    private List<IPerson> mNumberOfSubordinates;

    public Manager(Person person) {
        super(person);
        mNumberOfSubordinates = new ArrayList<IPerson>();
    }

    public void addSubordinate(Worker worker) {
        mNumberOfSubordinates.add(worker);
    }

    public void addSubordinates(List<Worker> workers) {
        mNumberOfSubordinates.addAll(workers);
    }

    @Override
    public String getHTMLFormattedName() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getFirstName());
        builder.append(" ");
        boolean toColor = false;
        if(getNumberOfSubordinates() > 20){
            builder.append("<font color='#00FF00'>");
            toColor = true;
        }

        builder.append(getLastName());

        if(toColor){
            builder.append("</font>");
        }


        return builder.toString();
    }

    public int getNumberOfSubordinates() {
        return mNumberOfSubordinates.size();
    }
}
