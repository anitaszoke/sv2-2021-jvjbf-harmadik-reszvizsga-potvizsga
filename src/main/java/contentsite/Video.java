package contentsite;

import java.util.ArrayList;
import java.util.List;

public class Video implements Content {
//    prémium tagság,ha 15 percnél hosszabbak

    private String title;
    private int length;
    private List<User> clickingUsers = new ArrayList<>();

    public Video(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public List<User> getClickingUsers() {
        return clickingUsers;
    }

    @Override
    public boolean isPremiumContent() {
        return length > 15;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return new ArrayList<>(clickingUsers);
    }

    @Override
    public void click(User user) {
        clickingUsers.add(user);

    }
}
