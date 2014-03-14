package kpk.dev.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krasimir.karamazov on 3/14/14.
 */
public class Manager extends EmployeeDecorator {

    private List<EmployeeDecorator> mNumberOfSubordinates;

    public Manager(Person person) {
        super(person);
        mNumberOfSubordinates = new ArrayList<EmployeeDecorator>();
        mNumberOfSubordinates.add()
    }

    public void addSubordinate(Worker worker) {
        mNumberOfSubordinates.add(worker);
    }

    public void addSubordinates(List<Worker> workers) {
        mNumberOfSubordinates.addAll(workers);
    }

    @Override
    public String getFormattedName() {
        return null;
    }

    public int getNumberOfSubordinates() {
        return mNumberOfSubordinates.size();
    }
}
