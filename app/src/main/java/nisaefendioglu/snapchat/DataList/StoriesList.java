package nisaefendioglu.snapchat.DataList;

public class StoriesList {

    private String name;
    private String clock;
    private int image;

    public StoriesList(String name, String clock, int image) {
        this.name = name;
        this.clock = clock;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
