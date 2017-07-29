package ariel.actiongroups.main.common.profiles;

public class Useri implements CommonProperties {
    CommonProp properties;

    @Override
    public String getName() {
        return properties.name;
    }
}
