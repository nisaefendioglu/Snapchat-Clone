package nisaefendioglu.snapchat.DataList;

public class ChatList {

    private String name;
    private String messageStatus;
    private int image;

    public ChatList(String name, String messageStatus, int image) {
        this.name = name;
        this.messageStatus = messageStatus;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

