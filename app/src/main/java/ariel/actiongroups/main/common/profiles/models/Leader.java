package ariel.actiongroups.main.common.profiles.models;

public class Leader extends User {

    private String company;
    private String website;

    public Leader(String id, String name, String company, String location, String profileImageUrl, String description, String website, String token) {
        super(id, name, location, profileImageUrl, description, token);
        this.company = company;
        this.website = website;
    }

    //Convenience Constructor from super class
    public Leader(){}


    //**Getters**//
    public java.lang.String getCompany() {
        return company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public java.lang.String getWebsite() {
        return website;
    }

    //**Setters**//
    public void setWebsite(java.lang.String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return super.toString() + " Company: " + company + " Website: " + website;
    }
}
