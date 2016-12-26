package ariel.actiongroups.main.common.profiles.models;

public class Leader extends User {
    public static final String NAME = "Name";
    public static final String LOCATION = "Location";
    public static final String URL = "Url";
    private String company;
    private String website;

    public Leader(String id, String name, String company, String location, String profileImageUrl, String description, String website, String token) {
        super(id, name, location, profileImageUrl, description, token);
        this.company = company;
        this.website = website;
    }

    //Convenience Constructor from super class
    public Leader(){}

    public java.lang.String getCompany() {
        return company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public java.lang.String getWebsite() {
        return website;
    }

    public void setWebsite(java.lang.String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        String leaderObjectDetails = NAME + ": " + getName() +
                " " + LOCATION  + ": " + getLocation() + " " +
                URL + ": " + getProfileImageUrl();
        return leaderObjectDetails;
    }
}

