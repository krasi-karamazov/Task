package kpk.dev.models;

/**
 * Created by krasimir.karamazov on 3/14/14.
 */
public abstract class EmployeeDecorator implements IPerson{

    private Person mPerson;

    public EmployeeDecorator(Person person) {
        mPerson = person;
    }

    @Override
    public void setFirstName(String firstName) {
        mPerson.setFirstName(firstName);
    }

    @Override
    public String getFirstName() {
        return mPerson.getFirstName();
    }

    @Override
    public void setLastName(String lastName) {
        mPerson.setLastName(lastName);
    }

    @Override
    public String getLastName() {
        return  mPerson.getLastName();
    }

    public abstract String getFormattedName();
}
