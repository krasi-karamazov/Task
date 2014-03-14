package kpk.dev.models;

/**
 * Created by krasimir.karamazov on 3/14/14.
 */
public class Person implements IPerson {
    private String mFirstName;
    private String mLastName;
    @Override
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    @Override
    public String getFirstName() {
        return mFirstName;
    }

    @Override
    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    @Override
    public String getLastName() {
        return mLastName;
    }
}
