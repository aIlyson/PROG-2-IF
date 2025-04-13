package dados;

public class Key {

    private String number;
    private String room;
    private String minLevel;

    public Key() {
        this.number = "";
        this.room = "";
        this.minLevel = "";
    }

    public Key(String number, String room, String minLevel) {
        this.number = number;
        this.room = room;
        this.minLevel = minLevel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(String minLevel) {
        this.minLevel = minLevel;
    }
}
