package dados;

import java.util.Date;

public class Reserve {
    private Teacher teacher;
    private Key key;
    private String id;
    private String activity;
    private String solicitation_hour;
    private String devolution_hour;

    public Reserve() {
        this.teacher = null;
        this.key = null;
        this.activity = "";
        this.solicitation_hour = "";
        this.devolution_hour = "";
        this.id = "";
    }

    public Reserve(Teacher teacher, Key key, String activity, String solicitation_hour, String devolution_hour, String id) {
        this.teacher = teacher;
        this.key = key;
        this.activity = activity;
        this.solicitation_hour = solicitation_hour;
        this.devolution_hour = devolution_hour;
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getSolicitation_hour() {
        return solicitation_hour;
    }

    public void setSolicitation_hour(String solicitation_hour) {
        this.solicitation_hour = solicitation_hour;
    }

    public String getDevolution_hour() {
        return devolution_hour;
    }

    public void setDevolution_hour(String devolution_hour) {
        this.devolution_hour = devolution_hour;
    }
}
