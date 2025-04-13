package dados;

public class Teacher {
    private String name;
    private String siape;
    private String accessLevel;

    public Teacher() {
        this.name = "";
        this.siape = "";
        this.accessLevel = "";
    }

    public Teacher(String name, String siape, String accessLevel) {
        this.name = name;
        this.siape = siape;
        this.accessLevel = accessLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}
