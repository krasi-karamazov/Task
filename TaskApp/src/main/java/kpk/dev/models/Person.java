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

    @Override
    public String getReadableData() {
        final StringBuilder builder = new StringBuilder();
        builder.append("First name:");
        builder.append(mFirstName);
        builder.append(" First name length:");
        builder.append(mFirstName.length());
        builder.append(" Last name:");
        builder.append(mLastName);
        builder.append(" Last name length:");
        builder.append(mLastName.length());
        return builder.toString();
    }
}
